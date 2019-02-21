package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

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
public abstract class ListScheduleModule {

    @Binds
    abstract AppCompatActivity provideAppActivity(ListScheduleActivity view);

    @Binds
    abstract ListScheduleNavigator provideNavigator( ListScheduleNavigatorImpl provider );

    @Provides
    static ListScheduleViewModel provideViewModel( ViewModelProvider.Factory factory, ListScheduleActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ListScheduleViewModel.class );
    }
}