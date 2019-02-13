package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class WaitingApprovementActivityModule {
    @Binds
    abstract WaitingApprovementNavigator provideNavigator( WaitingApprovementNavigatorImpl provider );

    @Provides
    static WaitingApprovementViewModel provideViewModel( ViewModelProvider.Factory factory, WaitingApprovementActivity view ) {
        return ViewModelProviders.of( view, factory ).get( WaitingApprovementViewModel.class );
    }
}