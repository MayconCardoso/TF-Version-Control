package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.cases.GetAppVersionsCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.cases.GetScheduleByVersionCase;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListScheduleViewModel extends BaseObservableViewModel<ListScheduleObservables, ListScheduleState> {

    private GetAppVersionsCase mGetAppVersionsCase;
    private GetScheduleByVersionCase mGetScheduleByVersionCase;

    @Inject
    public ListScheduleViewModel( GetAppVersionsCase getAppVersionsCase, GetScheduleByVersionCase getScheduleByVersionCase ) {
        mGetAppVersionsCase = getAppVersionsCase;
        mGetScheduleByVersionCase = getScheduleByVersionCase;
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

    public void setSelectedVersion( AppVersion version ){
        mState.mSelectedVersion.set( version );
        loadSchedule();
    }

    private void loadSchedule() {
        // Cancel open running.
        mGetAppVersionsCase.cancel();

        // Load schedule to version.
        RxCaseExecutor.execute( mGetScheduleByVersionCase, mState.mSelectedVersion.get() ).subscribe( new ObservableObserver<ScheduleDeploy>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                mState.mLoading.set( true );
            }

            @Override
            public void onNextEvent( ScheduleDeploy scheduleDeploy ) {
                mObservable.mSchedule.setValue( scheduleDeploy );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    private void showScheduleData( ScheduleDeploy scheduleDeploy ) {

    }
}