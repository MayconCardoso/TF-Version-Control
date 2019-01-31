package br.com.accera.mobile.tradeforceupdate.platform.di.module;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.data.appversion.repository.AppVersionRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.auth.repository.AuthRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.drawermenu.repository.DrawerMenuRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.user.repository.UserRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import br.com.accera.mobile.tradeforceupdate.domain.auth.repository.AuthRepository;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository.DrawerMenuRepository;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import dagger.Binds;
import dagger.Module;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
@Module
public abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract AuthRepository provideAuthRepository( AuthRepositoryImpl provider );

    @Binds
    abstract DrawerMenuRepository provideDrawerMenuRepository( DrawerMenuRepositoryImpl provider);

    @Binds
    abstract UserRepository provideUserRepository( UserRepositoryImpl provider );

    @Binds
    abstract AppVersionRepository provideAppVersionRepository( AppVersionRepositoryImpl provider );
}
