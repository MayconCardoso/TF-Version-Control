package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterAppVersionObservables implements DataObservable {
    public final SingleLiveEvent<Void> mBack = new SingleLiveEvent<>();

    @Inject
    public RegisterAppVersionObservables() {
    }
}
