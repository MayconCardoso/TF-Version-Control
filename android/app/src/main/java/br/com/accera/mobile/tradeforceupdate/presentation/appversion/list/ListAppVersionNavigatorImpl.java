package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.register.RegisterAppVersionActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListAppVersionNavigatorImpl extends NavigatorImpl implements ListAppVersionNavigator {
    @Inject
    public ListAppVersionNavigatorImpl( ListAppVersionActivity activity ) {
        super( activity );
    }

    @Override
    public void goToRegisterVersion() {
        navigate( RegisterAppVersionActivity.class );
    }
}
