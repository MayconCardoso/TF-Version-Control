package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.auth.cases.TryLogoutCase;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class DashboardViewModel extends BaseObservableViewModel<DashboardObservables, DashboardState> {

    private TryLogoutCase mTryLogoutCase;

    @Inject
    public DashboardViewModel( TryLogoutCase tryAuthenticateCase ) {
        mTryLogoutCase = addUseCase( tryAuthenticateCase );
    }

    public void tryLogout() {
        // Execute authentication case.
        RxCaseExecutor.execute( mTryLogoutCase ).subscribe( new CompletableObserver() {
            @Override
            public void onEventCompleted() {
                mObservable.mAuthScreen.call();
            }
        } );
    }
}