package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public interface AuthNavigator extends Navigator {
    void goToDashboard();
    void goToRequestAccess( String email );
}
