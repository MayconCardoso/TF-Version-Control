package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public interface RegisterUserNavigator extends Navigator {
    void goToWaitingAproveScreen( User user );
}
