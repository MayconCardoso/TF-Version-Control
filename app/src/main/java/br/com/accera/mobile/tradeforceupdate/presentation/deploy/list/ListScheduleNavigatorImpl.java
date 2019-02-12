package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule.ScheduleDeployActivity;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class ListScheduleNavigatorImpl extends NavigatorImpl implements ListScheduleNavigator {

    @Inject
    public ListScheduleNavigatorImpl( ListScheduleActivity activity ) {
        super( activity );
    }

    @Override
    public void goToRegisterSchecule() {
        navigate( ScheduleDeployActivity.class, false );
    }
}
