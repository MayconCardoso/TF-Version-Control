package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionNavigatorImpl extends NavigatorImpl implements PermissionNavigator  {

    @Inject
    public PermissionNavigatorImpl(PermissionActivity activity) {
        super(activity);
    }
}
