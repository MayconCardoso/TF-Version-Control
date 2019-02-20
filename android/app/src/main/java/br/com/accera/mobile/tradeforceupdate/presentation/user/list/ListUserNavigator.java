package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public interface ListUserNavigator extends Navigator {

    void goToPermissions(User user);
}
