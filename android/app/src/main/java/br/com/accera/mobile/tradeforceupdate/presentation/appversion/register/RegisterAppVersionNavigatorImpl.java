package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterAppVersionNavigatorImpl extends NavigatorImpl implements RegisterAppVersionNavigator {
    @Inject
    public RegisterAppVersionNavigatorImpl( RegisterAppVersionActivity activity ) {
        super( activity );
    }
}
