package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public interface ListInstanceNavigator extends Navigator {
    void goToRegisterInstance( Instance instance );
}
