package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class NeedApprovementModule {

    @Binds
    abstract NeedApprovementNavigator provideNavigator( NeedApprovementNavigatorImpl provider );

    @Provides
    static NeedApprovementViewModel provideViewModel(ViewModelProvider.Factory factory, NeedApprovementActivity view){
        return ViewModelProviders.of( view, factory ).get( NeedApprovementViewModel.class );
    }
}
