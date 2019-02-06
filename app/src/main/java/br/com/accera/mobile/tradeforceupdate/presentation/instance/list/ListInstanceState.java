package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import javax.inject.Inject;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ListInstanceState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final ObservableField<String> mInstance = new ObservableField<>( "" );

    @Inject
    public ListInstanceState() {
    }
}
