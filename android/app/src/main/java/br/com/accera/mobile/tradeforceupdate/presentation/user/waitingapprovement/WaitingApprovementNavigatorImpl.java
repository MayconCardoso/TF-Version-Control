package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class WaitingApprovementNavigatorImpl extends NavigatorImpl implements WaitingApprovementNavigator {

    @Inject
    public WaitingApprovementNavigatorImpl( WaitingApprovementActivity activity ) {
        super( activity );
    }

    @Override
    public void goToDashboard() {
        navigate( DashboardActivity.class, true );
    }
}
