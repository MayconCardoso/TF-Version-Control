package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import java.util.List;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ListAppVersionState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );

    @Inject
    public ListAppVersionState() {
    }
}
