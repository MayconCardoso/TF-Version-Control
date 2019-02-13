package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import android.os.Bundle;

import androidx.annotation.Nullable;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityAuthBinding;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class AuthActivity extends BaseMvvmActivity<ActivityAuthBinding, AuthViewModel, AuthNavigator> {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_auth;
    }

    private void registerObservables() {
        mViewModel.getObservable().mDashboardNavigation.observe( this, (__) -> mNavigator.goToDashboard());
        mViewModel.getObservable().mRequestAccessNavigation.observe( this, mNavigator::goToRequestAccess );
    }

}
