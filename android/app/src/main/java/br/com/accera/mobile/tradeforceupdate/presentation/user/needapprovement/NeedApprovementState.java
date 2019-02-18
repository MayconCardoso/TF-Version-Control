package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

public class NeedApprovementState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<Boolean> mAuthStatus = new ObservableField<>( false );

    @Inject
    public NeedApprovementState() {
    }
}
