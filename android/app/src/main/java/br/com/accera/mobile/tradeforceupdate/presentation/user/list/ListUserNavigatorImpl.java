package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.presentation.user.permissions.PermissionActivity;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class ListUserNavigatorImpl extends NavigatorImpl implements ListUserNavigator {

    @Inject
    public ListUserNavigatorImpl(ListUserActivity activity) {
        super(activity);
    }

    @Override
    public void goToPermissions(User user) {
        Bundle bundle = new Bundle();
        bundle.putSerializable( "USER", user );
        navigate( PermissionActivity.class, bundle, false );
    }
}
