package br.com.accera.mobile.tradeforceupdate.platform.di.module;

import android.app.Application;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.common.platform.util.ResourceUtil;
import br.com.accera.mobile.tradeforceupdate.platform.App;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;


/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
@Module
public abstract class AppModule {
    @Binds
    @Singleton
    abstract Application provideContext( App application );

    @Provides
    @Singleton
    static ResourceUtil provideResourceUtil( Application app ) {
        return new ResourceUtil( app );
    }
}