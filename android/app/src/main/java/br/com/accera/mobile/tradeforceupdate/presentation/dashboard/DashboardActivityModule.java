package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module(includes = DrawerMenuModule.class)
public abstract class DashboardActivityModule {

    @Binds
    abstract AppCompatActivity provideAppActivity( DashboardActivity view);

    @Binds
    abstract DashboardNavigator provideNavigator( DashboardNavigatorImpl provider );

    @Provides
    static DashboardViewModel provideViewModel( ViewModelProvider.Factory factory, DashboardActivity view ){
        return ViewModelProviders.of( view, factory ).get( DashboardViewModel.class );
    }
}