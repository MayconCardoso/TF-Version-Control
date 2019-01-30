package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.cases.GetDrawerMenuCase;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuViewModel extends BaseObservableViewModel<DrawerMenuObservables, DrawerMenuState> {

    private GetDrawerMenuCase mGetDrawerMenuCase;

    @Inject
    public DrawerMenuViewModel( GetDrawerMenuCase getDrawerMenuCase ) {
        mGetDrawerMenuCase = addUseCase( getDrawerMenuCase );
    }

    public void loadItems() {
        RxCaseExecutor.execute( mGetDrawerMenuCase ).subscribe( new ObservableObserver<Drawer>() {
            @Override
            public void onNextEvent( Drawer drawer ) {
                mObservable.mDrawerLoaded.setValue( drawer );
            }
        } );
    }
}
