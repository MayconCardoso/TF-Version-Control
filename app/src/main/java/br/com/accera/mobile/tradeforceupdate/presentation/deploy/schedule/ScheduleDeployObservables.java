package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ScheduleDeployObservables implements DataObservable {
    public final SingleLiveEvent<Void> mBack = new SingleLiveEvent<>();

    @Inject
    public ScheduleDeployObservables() {
    }
}
