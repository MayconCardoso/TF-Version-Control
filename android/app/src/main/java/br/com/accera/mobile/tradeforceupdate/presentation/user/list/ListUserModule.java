package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

@Module
public abstract class ListUserModule {

    @Binds
    abstract ListUserNavigator provideNavigator(ListUserNavigatorImpl provider );

    @Provides
    static ListUserViewModel provideViewModel(ViewModelProvider.Factory factory, ListUserActivity view){
        return ViewModelProviders.of( view, factory ).get( ListUserViewModel.class );
    }
}
