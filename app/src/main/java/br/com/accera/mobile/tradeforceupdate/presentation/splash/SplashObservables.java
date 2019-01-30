package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class SplashObservables implements DataObservable {
    public final SingleLiveEvent<Void> mDashboardNavitation = new SingleLiveEvent<>();
    public final SingleLiveEvent<Void> mLoginNavitation = new SingleLiveEvent<>();
    public final SingleLiveEvent<User> mWaitingAppovementNavitation = new SingleLiveEvent<>();
    public final SingleLiveEvent<Throwable> mError = new SingleLiveEvent<>();

    @Inject
    public SplashObservables() {
    }
}
