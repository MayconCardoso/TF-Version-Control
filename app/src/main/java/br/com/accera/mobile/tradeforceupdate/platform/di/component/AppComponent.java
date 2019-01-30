package br.com.accera.mobile.tradeforceupdate.platform.di.component;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.platform.App;
import br.com.accera.mobile.tradeforceupdate.platform.auth.AuthDataModule;
import br.com.accera.mobile.tradeforceupdate.platform.di.builder.ActivityBuilder;
import br.com.accera.mobile.tradeforceupdate.platform.di.module.AppModule;
import br.com.accera.mobile.tradeforceupdate.platform.di.module.DatasourceModule;
import br.com.accera.mobile.tradeforceupdate.platform.di.module.RepositoryModule;
import br.com.accera.mobile.tradeforceupdate.platform.di.module.ViewModelModule;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.auth.FirebaseAuthModule;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.FirebaseFirestoreModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;


/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
@Singleton
@Component( modules = {
        AndroidInjectionModule.class,
        ActivityBuilder.class,

        DatasourceModule.class,
        RepositoryModule.class,
        ViewModelModule.class,

        AppModule.class,
        AuthDataModule.class,
        FirebaseAuthModule.class,
        FirebaseFirestoreModule.class
} )
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application( App application );

        AppComponent build();
    }
}