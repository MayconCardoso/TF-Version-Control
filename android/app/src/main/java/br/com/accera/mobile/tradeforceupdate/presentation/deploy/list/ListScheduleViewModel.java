package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.cases.GetAppVersionsCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.cases.DoDeployCase;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.cases.GetScheduleByVersionCase;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListScheduleViewModel extends BaseObservableViewModel<ListScheduleObservables, ListScheduleState> {

    private GetAppVersionsCase mGetAppVersionsCase;
    private GetScheduleByVersionCase mGetScheduleByVersionCase;
    private DoDeployCase mDoDeployCase;

    @Inject
    public ListScheduleViewModel( GetAppVersionsCase getAppVersionsCase, GetScheduleByVersionCase getScheduleByVersionCase, DoDeployCase doDeployCase ) {
        mGetAppVersionsCase = getAppVersionsCase;
        mGetScheduleByVersionCase = getScheduleByVersionCase;
        mDoDeployCase = doDeployCase;
    }

    public void goToRegisterPage() {
        getObservable().mRegister.call();
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
                if( appVersions.isEmpty()) {
                    return;
                }
                setSelectedVersion( appVersions.get( 0 ) );
            }
        } );
    }

    private void loadSchedule() {
        // Cancel open running.
        mGetAppVersionsCase.cancel();
        mState.mCurrentDeploy.set( null );

        // Load schedule to version.
        RxCaseExecutor.execute( mGetScheduleByVersionCase, mState.mSelectedVersion.get() ).subscribe( new ObservableObserver<ScheduleDeploy>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                mState.mLoading.set( true );
            }

            @Override
            public void onNextEvent( ScheduleDeploy scheduleDeploy ) {
                mState.mCurrentDeploy.set( scheduleDeploy.getDeploys().get( 0 ) );
                mObservable.mSchedule.setValue( scheduleDeploy );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    public void setSelectedVersion( AppVersion version ){
        mState.mSelectedVersion.set( version );
        loadSchedule();
    }

    public void setSelectedDeploy( Deploy deploy ){
        mState.mCurrentDeploy.set( deploy );
    }

    public void doDeploy( Deploy deploy ) {
        RxCaseExecutor.execute( mDoDeployCase, deploy ).subscribe( new CompletableObserver() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                mState.mLoading.set( true );
            }

            @Override
            public void onEventCompleted() {
                getAlertFeedback().postValue( new AlertMessage.Builder()
                        .setTitle( R.string.sucesso )
                        .setMessage( R.string.deploy_sucessfull )
                );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }

            @Override
            public void onErrorEvent(Throwable e) {
                super.onErrorEvent(e);
                getAlertFeedback().setValue( new AlertMessage.Builder()
                        .setTitle( R.string.atenttion )
                        .setMessage( e.getMessage() )
                );
            }
        } );
    }
}