package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterInstanceNavigatorImpl extends NavigatorImpl implements RegisterInstanceNavigator {
    @Inject
    public RegisterInstanceNavigatorImpl( RegisterInstanceActivity activity ) {
        super( activity );
    }
}
