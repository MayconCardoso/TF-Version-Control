package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.RequiredFieldValidation;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.cases.GetAppVersionsCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.instance.cases.RegisterInstanceCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.InstanceOwner;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterInstanceViewModel extends BaseObservableViewModel<RegisterInstanceObservables, RegisterInstanceState> {

    private RegisterInstanceCase mRegisterCase;
    private GetAppVersionsCase mGetAppVersionsCase;

    @Inject
    public RegisterInstanceViewModel( RegisterInstanceCase registerUserCase, GetAppVersionsCase getAppVersionsCase ) {
        mRegisterCase = addUseCase( registerUserCase );
        mGetAppVersionsCase = addUseCase( getAppVersionsCase );
    }

    public void loadVersions() {
        RxCaseExecutor.execute( mGetAppVersionsCase ).subscribe( new ObservableObserver<List<AppVersion>>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                mState.mLoading.set( true );
            }

            @Override
            public void onNextEvent( List<AppVersion> appVersions ) {
                mObservable.mAppVersions.postValue( appVersions );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    public void register( String name, String dbName, String mdm, String countUsers, AppVersion version, InstanceOwner owner, int updateGroup ) {
        Instance instance = createRequest( name, dbName, mdm, countUsers, version, owner, updateGroup );

        cleanAllErrors();

        if( isDataInvalid( instance, countUsers ) ) {
            return;
        }

        // Run use case
        RxCaseExecutor.execute( mRegisterCase, instance ).subscribe( new CompletableObserver() {
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

    private boolean isDataInvalid( Instance item, String count ) {
        // Required fields
        boolean valid = RequiredFieldValidation.check( mResourceUtil, item.getName(), mState.mNameError );
        valid &= RequiredFieldValidation.check( mResourceUtil, item.getDbName(), mState.mDbNameError );
        valid &= RequiredFieldValidation.check( mResourceUtil, count, mState.mTotalUserError );
        return !valid;
    }

    private Instance createRequest( String name, String dbName, String mdm, String countUsers, AppVersion version, InstanceOwner owner, int updateGroup ) {
        Instance request = new Instance();
        request.setName( name );
        request.setDbName( dbName );
        request.setMdm( mdm );
        request.setUpdateGroup( updateGroup );
        request.setTotalUsuarios( countUsers.isEmpty() ? 0 : Integer.parseInt( countUsers ) );
        request.setCurrentVersion( version );
        request.setOwner( owner );
        return request;
    }

    private void cleanAllErrors() {
        mState.mNameError.set( "" );
        mState.mDbNameError.set( "" );
        mState.mTotalUserError.set( "" );
    }
}