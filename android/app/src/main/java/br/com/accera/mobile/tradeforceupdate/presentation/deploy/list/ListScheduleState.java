package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ListScheduleState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<AppVersion> mSelectedVersion = new ObservableField<>();
    public final ObservableField<Deploy> mCurrentDeploy = new ObservableField<>();

    @Inject
    public ListScheduleState() {
    }
}
