package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class WaitingApprovementObservables implements DataObservable {
    public final SingleLiveEvent<Void> mDashboardNavigation = new SingleLiveEvent<>();

    @Inject
    public WaitingApprovementObservables() {
    }
}
