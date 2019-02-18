package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

public class NeedApprovementObservables implements DataObservable {
    public final SingleLiveEvent<String> mApprove = new SingleLiveEvent<>();
    public final MutableLiveData<List<User>> mUsers = new MutableLiveData<>();

    @Inject
    public NeedApprovementObservables() {
    }
}
