package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository;

import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public interface DrawerMenuRepository {
    Completable createMenu();

    Observable<Drawer> getDrawerMenu();
}
