package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class WaitingApprovementState implements DataState {
    public final ObservableField<String> mMessage = new ObservableField<>();
    public final ObservableBoolean mWaitingApprovement = new ObservableBoolean( true );

    @Inject
    public WaitingApprovementState() {
    }
}
