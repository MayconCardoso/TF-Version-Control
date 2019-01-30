package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class DashboardActivityModule {

    @Binds
    abstract AppCompatActivity provideAppActivity( DashboardActivity view);

    @Binds
    abstract LifecycleOwner provideLifecycleOwner( DashboardActivity view);

    @Binds
    abstract DashboardNavigator provideNavigator( DashboardNavigatorImpl provider );

    @Provides
    static DashboardViewModel provideViewModel( ViewModelProvider.Factory factory, DashboardActivity view ){
        return ViewModelProviders.of( view, factory ).get( DashboardViewModel.class );
    }
}