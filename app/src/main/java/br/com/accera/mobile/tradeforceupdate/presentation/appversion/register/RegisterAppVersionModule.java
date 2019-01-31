package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class RegisterAppVersionModule {
    @Binds
    abstract RegisterAppVersionNavigator provideNavigator( RegisterAppVersionNavigatorImpl provider );

    @Provides
    static RegisterAppVersionViewModel provideViewModel( ViewModelProvider.Factory factory, RegisterAppVersionActivity view ) {
        return ViewModelProviders.of( view, factory ).get( RegisterAppVersionViewModel.class );
    }
}