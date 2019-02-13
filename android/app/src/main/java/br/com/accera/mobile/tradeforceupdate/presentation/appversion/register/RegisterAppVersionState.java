package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RegisterAppVersionState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mVersionCode = new ObservableField<>();
    public final ObservableField<String> mVersionName = new ObservableField<>();
    public final ObservableField<String> mApkLink = new ObservableField<>();

    @Inject
    public RegisterAppVersionState() {
    }
}
