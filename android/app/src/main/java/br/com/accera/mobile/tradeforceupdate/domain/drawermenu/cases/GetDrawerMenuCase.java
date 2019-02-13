package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository.DrawerMenuRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 23/01/2019.
 */
public class GetDrawerMenuCase extends EntityObserverCase<Void, Drawer> {
    private DrawerMenuRepository mRepository;

    @Inject
    public GetDrawerMenuCase( DrawerMenuRepository repository ) {
        mRepository = repository;
    }

    @Override
    protected Observable<Drawer> getObservable( Void input) {
        return mRepository.getDrawerMenu();
    }
}
