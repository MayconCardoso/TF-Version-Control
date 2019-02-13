package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class DrawerMenuModule {
    @Provides
    static DrawerMenuViewModel provideViewModel( ViewModelProvider.Factory factory, AppCompatActivity view ) {
        return ViewModelProviders.of( view, factory ).get( DrawerMenuViewModel.class );
    }
}