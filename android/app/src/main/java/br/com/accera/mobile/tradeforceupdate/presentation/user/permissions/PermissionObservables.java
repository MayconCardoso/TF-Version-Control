package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionObservables implements DataObservable {
    public final SingleLiveEvent<Void> mGoBack = new SingleLiveEvent<>();
    public MutableLiveData<List<Permission>> mPermissions = new MutableLiveData<>();

    @Inject
    public PermissionObservables() {
    }
}
