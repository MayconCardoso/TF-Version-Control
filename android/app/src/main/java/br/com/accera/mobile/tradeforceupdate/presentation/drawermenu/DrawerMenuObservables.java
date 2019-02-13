package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.DataObservable;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class DrawerMenuObservables implements DataObservable {
    public final SingleLiveEvent<Drawer> mDrawerLoaded = new SingleLiveEvent<>();

    @Inject
    public DrawerMenuObservables() {
    }
}
