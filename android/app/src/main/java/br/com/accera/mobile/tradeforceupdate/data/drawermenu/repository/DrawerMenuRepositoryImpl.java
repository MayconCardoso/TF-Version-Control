package br.com.accera.mobile.tradeforceupdate.data.drawermenu.repository;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource.DrawerMenuDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository.DrawerMenuRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuRepositoryImpl implements DrawerMenuRepository {

    private DrawerMenuDatasource mDrawerMenuDatasource;

    @Inject
    public DrawerMenuRepositoryImpl( DrawerMenuDatasource drawerMenuDatasource ) {
        mDrawerMenuDatasource = drawerMenuDatasource;
    }

    @Override
    public Completable createMenu() {
        return mDrawerMenuDatasource.createMenu();
    }

    @Override
    public Observable<Drawer> getDrawerMenu() {
        return mDrawerMenuDatasource.getDrawerMenu();
    }
}
