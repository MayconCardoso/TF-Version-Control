package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import javax.inject.Inject;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataState;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class ListUserState implements DataState {
    public final ObservableBoolean mLoading = new ObservableBoolean( false );
    public final MutableLiveData<Boolean> mAuthStatus = new MutableLiveData<>( true );

    @Inject
    public ListUserState() {
    }
}
