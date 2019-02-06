package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.register.RegisterInstanceActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListInstanceNavigatorImpl extends NavigatorImpl implements ListInstanceNavigator {
    @Inject
    public ListInstanceNavigatorImpl( ListInstanceActivity activity ) {
        super( activity );
    }

    @Override
    public void goToRegisterInstance() {
        navigate( RegisterInstanceActivity.class );
    }
}
