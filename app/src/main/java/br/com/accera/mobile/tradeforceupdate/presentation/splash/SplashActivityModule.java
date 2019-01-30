package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module(includes = DrawerMenuModule.class)
public abstract class SplashActivityModule {
    @Binds
    abstract SplashNavigator provideSplashNavigator( SplashNavigatorImpl provider );

    @Provides
    static SplashViewModel provideViewModel( ViewModelProvider.Factory factory, SplashActivity view ) {
        return ViewModelProviders.of( view, factory ).get( SplashViewModel.class );
    }
}