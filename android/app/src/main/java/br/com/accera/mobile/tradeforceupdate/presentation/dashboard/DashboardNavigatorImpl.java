package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.auth.AuthActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class DashboardNavigatorImpl extends NavigatorImpl implements DashboardNavigator {

    @Inject
    public DashboardNavigatorImpl( DashboardActivity activity ) {
        super( activity );
    }

    @Override
    public void goToLogin() {
        navigate( AuthActivity.class, true );
    }
}
