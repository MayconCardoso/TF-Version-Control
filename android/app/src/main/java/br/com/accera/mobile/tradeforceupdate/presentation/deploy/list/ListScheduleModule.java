package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class ListScheduleModule {
    @Binds
    abstract ListScheduleNavigator provideNavigator( ListScheduleNavigatorImpl provider );

    @Provides
    static ListScheduleViewModel provideViewModel( ViewModelProvider.Factory factory, ListScheduleActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ListScheduleViewModel.class );
    }
}