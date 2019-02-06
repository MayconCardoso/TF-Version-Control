package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ListInstanceObservables implements DataObservable {
    public final SingleLiveEvent<Void> mRegister = new SingleLiveEvent<>();
    public final MutableLiveData<List<Instance>> mItens = new MutableLiveData<>();

    @Inject
    public ListInstanceObservables() {
    }
}
