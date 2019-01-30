package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.presentation.auth.AuthActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement.WaitingApprovementActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class SplashNavigatorImpl extends NavigatorImpl implements SplashNavigator {

    @Inject
    public SplashNavigatorImpl(SplashActivity activity) {
        super(activity);
    }

    @Override
    public void goToLogin() {
        navigate( AuthActivity.class, true );
    }

    @Override
    public void goToDashboard() {
        navigate( DashboardActivity.class, true );
    }

    @Override
    public void goToWaitingAproveScreen( User user ) {
        Bundle bundle = new Bundle();
        bundle.putSerializable( "USER", user );
        navigate( WaitingApprovementActivity.class, bundle, true );
    }
}
