package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class ListInstanceModule {
    @Binds
    abstract ListInstanceNavigator provideNavigator( ListInstanceNavigatorImpl provider );

    @Provides
    static ListInstanceViewModel provideViewModel( ViewModelProvider.Factory factory, ListInstanceActivity view ) {
        return ViewModelProviders.of( view, factory ).get( ListInstanceViewModel.class );
    }
}