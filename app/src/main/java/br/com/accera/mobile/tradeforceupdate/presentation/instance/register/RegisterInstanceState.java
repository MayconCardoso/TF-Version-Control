package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterInstanceState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mNameError = new ObservableField<>();
    public final ObservableField<String> mDbNameError = new ObservableField<>();
    public final ObservableField<String> mTotalUserError = new ObservableField<>();

    @Inject
    public RegisterInstanceState() {
    }
}
