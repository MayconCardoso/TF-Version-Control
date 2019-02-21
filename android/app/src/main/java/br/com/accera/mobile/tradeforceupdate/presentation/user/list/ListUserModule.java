package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

@Module(includes = DrawerMenuModule.class)
public abstract class ListUserModule {

    @Binds
    abstract AppCompatActivity provideAppActivity(ListUserActivity view);

    @Binds
    abstract ListUserNavigator provideNavigator(ListUserNavigatorImpl provider );

    @Provides
    static ListUserViewModel provideViewModel(ViewModelProvider.Factory factory, ListUserActivity view){
        return ViewModelProviders.of( view, factory ).get( ListUserViewModel.class );
    }
}
