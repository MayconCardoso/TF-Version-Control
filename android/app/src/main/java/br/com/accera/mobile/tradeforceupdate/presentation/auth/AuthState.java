package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class AuthState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mEmailError = new ObservableField<>();
    public final ObservableField<String> mPasswordError = new ObservableField<>();

    @Inject
    public AuthState() {
    }
}
