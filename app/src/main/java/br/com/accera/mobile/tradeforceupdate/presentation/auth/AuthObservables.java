package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class AuthObservables implements DataObservable {
    public final SingleLiveEvent<Void> mDashboardNavigation = new SingleLiveEvent<>();
    public final SingleLiveEvent<String> mRequestAccessNavigation = new SingleLiveEvent<>();

    @Inject
    public AuthObservables() {
    }
}
