package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class ListAppVersionModule {
    @Binds
    abstract ListAppVersionNavigator provideNavigator( ListAppVersionNavigatorImpl provider );

    @Provides
    static ListAppVersionViewModel provideViewModel( ViewModelProvider.Factory factory, ListAppVersionActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ListAppVersionViewModel.class );
    }
}