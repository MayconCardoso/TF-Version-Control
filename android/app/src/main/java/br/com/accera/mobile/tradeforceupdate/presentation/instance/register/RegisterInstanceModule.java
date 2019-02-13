package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.register.RegisterAppVersionViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class RegisterInstanceModule {
    @Binds
    abstract RegisterInstanceNavigator provideNavigator( RegisterInstanceNavigatorImpl provider );

    @Provides
    static RegisterAppVersionViewModel provideViewModel( ViewModelProvider.Factory factory, RegisterInstanceActivity view ) {
        return ViewModelProviders.of( view, factory ).get( RegisterAppVersionViewModel.class );
    }
}