package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.cases.GetAppVersionsCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListAppVersionViewModel extends BaseObservableViewModel<ListAppVersionObservables, ListAppVersionState> {

    private GetAppVersionsCase mGetAppVersionsCase;

    @Inject
    public ListAppVersionViewModel( GetAppVersionsCase getAll ) {
        mGetAppVersionsCase = addUseCase( getAll );
    }

    public void goToRegisterPage() {
        getObservable().mRegisterVersion.call();
    }

    public void getVersions() {
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
}