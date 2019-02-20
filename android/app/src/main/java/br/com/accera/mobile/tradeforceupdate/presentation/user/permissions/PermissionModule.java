package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

@Module
public abstract class PermissionModule {

    @Binds
    abstract PermissionNavigator provideNavigator(PermissionNavigatorImpl provider );

    @Provides
    static PermissionViewModel provideViewModel(ViewModelProvider.Factory factory, PermissionActivity view){
        return ViewModelProviders.of( view, factory ).get( PermissionViewModel.class );
    }

}
