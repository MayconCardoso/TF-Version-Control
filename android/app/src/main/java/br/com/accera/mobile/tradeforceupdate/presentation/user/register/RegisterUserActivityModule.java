package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class RegisterUserActivityModule {
    @Binds
    abstract RegisterUserNavigator provideNavigator( RegisterUserNavigatorImpl provider );

    @Provides
    static RegisterUserViewModel provideViewModel( ViewModelProvider.Factory factory, RegisterUserActivity view ) {
        return ViewModelProviders.of( view, factory ).get( RegisterUserViewModel.class );
    }
}