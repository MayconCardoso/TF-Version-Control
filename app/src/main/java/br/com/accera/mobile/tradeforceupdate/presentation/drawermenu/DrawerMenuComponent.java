package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import com.mikepenz.materialdrawer.DrawerBuilder;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuComponent implements LifecycleObserver {
    private AppCompatActivity mActivity;
    private DrawerMenuViewModel mDrawerMenuViewModel;

    @Inject
    public DrawerMenuComponent( AppCompatActivity activity, DrawerMenuViewModel drawerMenuViewModel ) {
        mActivity = activity;
        mDrawerMenuViewModel = drawerMenuViewModel;
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_CREATE )
    public void setUp() {
        mDrawerMenuViewModel.getObservable().mDrawerLoaded.observe( mActivity, this::createDrawerMenu );
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_START )
    public void observerDrawerMenu() {
        mDrawerMenuViewModel.loadItems();
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_STOP )
    public void cancelDrawerMenu() {
    }

    private void createDrawerMenu( Drawer drawer ) {
        new DrawerBuilder()
                .withActivity( mActivity )
                .build();
    }
}
