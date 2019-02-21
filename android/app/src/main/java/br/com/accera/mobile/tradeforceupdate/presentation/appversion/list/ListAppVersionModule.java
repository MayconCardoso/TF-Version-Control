package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

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
public abstract class ListAppVersionModule {

    @Binds
    abstract AppCompatActivity provideAppActivity(ListAppVersionActivity view);

    @Binds
    abstract ListAppVersionNavigator provideNavigator( ListAppVersionNavigatorImpl provider );

    @Provides
    static ListAppVersionViewModel provideViewModel( ViewModelProvider.Factory factory, ListAppVersionActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ListAppVersionViewModel.class );
    }
}