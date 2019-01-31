package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.RequiredFieldValidation;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.DateUtil;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.cases.RegisterAppVersionCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.RegisterUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;
import br.com.accera.mobile.tradeforceupdate.platform.rx.SingleObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterAppVersionViewModel extends BaseObservableViewModel<RegisterAppVersionObservables, RegisterAppVersionState> {

    private RegisterAppVersionCase mRegisterCase;

    @Inject
    public RegisterAppVersionViewModel( RegisterAppVersionCase registerUserCase ) {
        mRegisterCase = addUseCase( registerUserCase );
    }

    public void register( String versionCode, String versionName, String link ) {
        AppVersion version = createRequest( versionCode, versionName, link );

        cleanAllErrors();

        if( isDataInvalid( version ) ) {
            return;
        }

        // Run use case
        RxCaseExecutor.execute( mRegisterCase, version ).subscribe( new CompletableObserver() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                getHideKeyboard().call();
                mState.mLoading.set( true );
            }

            @Override
            public void onEventCompleted() {
                mObservable.mBack.call();
            }

            @Override
            public void onErrorEvent( Throwable throwable ) {
                getAlertFeedback().setValue( new AlertMessage.Builder()
                        .setTitle( R.string.atenttion )
                        .setMessage( throwable.getMessage() )
                );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    private boolean isDataInvalid( AppVersion version ) {
        // Required fields
        boolean valid = RequiredFieldValidation.check( mResourceUtil, version.getVersionName(), mState.mVersionName );
        valid &= RequiredFieldValidation.check( mResourceUtil, version.getApkPath(), mState.mApkLink );
        valid &= RequiredFieldValidation.check( mResourceUtil, version.getVersionCode(), mState.mVersionCode );
        return !valid;
    }

    private AppVersion createRequest( String versionCode, String versionName, String link ) {
        AppVersion request = new AppVersion();
        request.setApkPath( link );
        request.setVersionCode( versionCode );
        request.setVersionName( versionName );
        request.setCreatedDate( DateUtil.getCurrentDate() );
        return request;
    }

    private void cleanAllErrors() {
        mState.mApkLink.set( "" );
        mState.mVersionCode.set( "" );
        mState.mVersionName.set( "" );
    }
}