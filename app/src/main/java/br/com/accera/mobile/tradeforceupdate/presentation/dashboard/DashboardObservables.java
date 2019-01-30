package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class DashboardObservables implements DataObservable {
    public final SingleLiveEvent<Void> mAuthScreen = new SingleLiveEvent<>();

    @Inject
    public DashboardObservables() {
    }
}
