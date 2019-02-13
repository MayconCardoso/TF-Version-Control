package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterUserState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mFirstNameError = new ObservableField<>();
    public final ObservableField<String> mLastNameError = new ObservableField<>();
    public final ObservableField<String> mEmailError = new ObservableField<>();
    public final ObservableField<String> mPasswordError = new ObservableField<>();

    @Inject
    public RegisterUserState() {
    }
}
