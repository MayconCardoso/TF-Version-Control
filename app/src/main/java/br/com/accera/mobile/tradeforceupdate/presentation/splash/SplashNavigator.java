package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public interface SplashNavigator extends Navigator {
    void goToLogin();
    void goToDashboard();
    void goToWaitingAproveScreen( User user );
}
