package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ScheduleDeployNavigatorImpl extends NavigatorImpl implements ScheduleDeployNavigator {
    @Inject
    public ScheduleDeployNavigatorImpl( ScheduleDeployActivity activity ) {
        super( activity );
    }
}
