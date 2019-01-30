package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class AuthActivityModule {
    @Binds
    abstract AuthNavigator provideNavigator( AuthNavigatorImpl provider );

    @Provides
    static AuthViewModel provideAuthViewModel( ViewModelProvider.Factory factory, AuthActivity authActivity ){
        return ViewModelProviders.of( authActivity, factory ).get( AuthViewModel.class );
    }
}