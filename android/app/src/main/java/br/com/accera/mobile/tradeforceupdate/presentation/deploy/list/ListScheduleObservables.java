package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ListScheduleObservables implements DataObservable {
    public final SingleLiveEvent<Void> mRegister = new SingleLiveEvent<>();
    public final MutableLiveData<ScheduleDeploy> mSchedule = new MutableLiveData<>();
    public final MutableLiveData<List<AppVersion>> mAppVersions = new MutableLiveData<>();

    @Inject
    public ListScheduleObservables() {
    }
}
