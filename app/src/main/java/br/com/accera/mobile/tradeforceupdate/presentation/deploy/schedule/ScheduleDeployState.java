package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ScheduleDeployState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mInitialPercentError = new ObservableField<>();
    public final ObservableField<String> mCountDeployError = new ObservableField<>();
    public final ObservableField<String> mCountNecessaryDaysError = new ObservableField<>();

    @Inject
    public ScheduleDeployState() {
    }
}
