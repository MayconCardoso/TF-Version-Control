package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class ScheduleDeployModule {
    @Binds
    abstract ScheduleDeployNavigator provideNavigator( ScheduleDeployNavigatorImpl provider );

    @Provides
    static ScheduleDeployViewModel provideViewModel( ViewModelProvider.Factory factory, ScheduleDeployActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ScheduleDeployViewModel.class );
    }
}