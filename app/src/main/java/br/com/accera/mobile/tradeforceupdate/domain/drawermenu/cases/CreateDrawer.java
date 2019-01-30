package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository.DrawerMenuRepository;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class CreateDrawer extends CompletableUseCase<Void> {

    private DrawerMenuRepository mDrawerMenuRepository;

    @Inject
    public CreateDrawer( DrawerMenuRepository drawerMenuRepository ) {
        mDrawerMenuRepository = drawerMenuRepository;
    }

    @Override
    public Completable run( Void value ) {
        return mDrawerMenuRepository.createMenu();
    }
}
