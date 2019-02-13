package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterUserObservables implements DataObservable {
    public final SingleLiveEvent<User> mWaitingApprovement = new SingleLiveEvent<>();

    @Inject
    public RegisterUserObservables() {
    }
}
