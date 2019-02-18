package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.NavigatorImpl;

public class NeedApprovementNavigatorImpl extends NavigatorImpl implements NeedApprovementNavigator {

    @Inject
    public NeedApprovementNavigatorImpl(NeedApprovementActivity activity) {
        super(activity);
    }
}
