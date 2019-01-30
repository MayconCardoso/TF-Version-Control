package br.com.accera.mobile.tradeforceupdate.platform;

import br.com.accera.mobile.tradeforceupdate.platform.di.component.DaggerAppComponent;
import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppLogger.init();
    }

    @Override
    protected AndroidInjector<App> applicationInjector() {
        return DaggerAppComponent.builder()
                .application( this )
                .build();
    }
}
