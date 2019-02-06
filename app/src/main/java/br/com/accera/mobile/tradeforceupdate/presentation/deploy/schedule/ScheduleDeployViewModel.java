package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.RequiredFieldValidation;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.cases.ScheduleDeployCase;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ScheduleDeployViewModel extends BaseObservableViewModel<ScheduleDeployObservables, ScheduleDeployState> {

    private ScheduleDeployCase mCreateCalendarCase;

    @Inject
    public ScheduleDeployViewModel( ScheduleDeployCase registerUserCase ) {
        mCreateCalendarCase = addUseCase( registerUserCase );
    }

    public void register( AppVersion selectedAppVersion, String daysNecessary, String initialPercent, String countDeploys ) {
        cleanAllErrors();

        if( isDataInvalid( daysNecessary, initialPercent, countDeploys ) ) {
            return;
        }

        // Run use case
        RxCaseExecutor.execute( mCreateCalendarCase, new ScheduleDeployCase.Request(
                Integer.parseInt( countDeploys ),
                Integer.parseInt( daysNecessary ),
                Integer.parseInt( initialPercent ),
                selectedAppVersion
        ) ).subscribe( new CompletableObserver() {
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

    private boolean isDataInvalid( String daysNecessary, String initialPercent, String countDeploys ) {
        // Required fields
        boolean valid = RequiredFieldValidation.check( mResourceUtil, countDeploys, mState.mCountDeployError );
        valid &= RequiredFieldValidation.check( mResourceUtil, daysNecessary, mState.mCountNecessaryDaysError );
        valid &= RequiredFieldValidation.check( mResourceUtil, initialPercent, mState.mInitialPercentError );
        return !valid;
    }

    private void cleanAllErrors() {
        mState.mCountNecessaryDaysError.set( "" );
        mState.mInitialPercentError.set( "" );
        mState.mCountDeployError.set( "" );
    }
}