package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import android.os.Bundle;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement.WaitingApprovementActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterUserNavigatorImpl extends NavigatorImpl implements RegisterUserNavigator {

    @Inject
    public RegisterUserNavigatorImpl( RegisterUserActivity activity ) {
        super( activity );
    }

    @Override
    public void goToWaitingAproveScreen( User user ) {
        Bundle bundle = new Bundle();
        bundle.putSerializable( "USER", user );
        navigate( WaitingApprovementActivity.class, bundle, true );
    }
}
