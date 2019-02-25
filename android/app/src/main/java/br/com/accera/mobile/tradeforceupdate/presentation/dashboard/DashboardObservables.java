package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import java.util.HashMap;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class DashboardObservables implements DataObservable {
    public final SingleLiveEvent<Void> mAuthScreen = new SingleLiveEvent<>();

    public final MutableLiveData<HashMap> mPieChartInstances = new MutableLiveData<>();

    @Inject
    public DashboardObservables() {
    }
}
