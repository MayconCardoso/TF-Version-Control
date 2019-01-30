package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.user.register.RegisterUserActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class AuthNavigatorImpl extends NavigatorImpl implements AuthNavigator {

    @Inject
    public AuthNavigatorImpl( AuthActivity activity ) {
        super( activity );
    }

    @Override
    public void goToRequestAccess( String email ) {
        if(email == null){
            navigate( RegisterUserActivity.class );
            return;
        }

        Bundle extras = new Bundle();
        extras.putString( "EMAIL", email );
        navigate( RegisterUserActivity.class, extras, false );
    }

    @Override
    public void goToDashboard() {
        navigate( DashboardActivity.class, true );
    }
}
