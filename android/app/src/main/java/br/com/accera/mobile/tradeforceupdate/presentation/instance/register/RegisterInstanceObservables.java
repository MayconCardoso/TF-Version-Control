package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterInstanceObservables implements DataObservable {
    public final SingleLiveEvent<Void> mBack = new SingleLiveEvent<>();
    public final MutableLiveData<List<AppVersion>> mAppVersions = new MutableLiveData<>();

    @Inject
    public RegisterInstanceObservables() {
    }
}
