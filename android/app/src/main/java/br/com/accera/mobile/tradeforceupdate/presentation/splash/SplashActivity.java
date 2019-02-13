package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivitySplashscreenBinding;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class SplashActivity extends BaseMvvmActivity<ActivitySplashscreenBinding, SplashViewModel, SplashNavigator> {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splashscreen;
    }

    private void registerObservables() {
        // Register observables
        mViewModel.getObservable().mWaitingAppovementNavitation.observe( this, mNavigator::goToWaitingAproveScreen );
        mViewModel.getObservable().mDashboardNavitation.observe( this, ( __ ) -> mNavigator.goToDashboard() );
        mViewModel.getObservable().mLoginNavitation.observe( this, ( __ ) -> mNavigator.goToLogin() );
        mViewModel.checkAuth();
    }
}
