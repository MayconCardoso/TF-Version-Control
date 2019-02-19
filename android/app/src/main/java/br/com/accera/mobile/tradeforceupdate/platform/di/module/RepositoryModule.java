package br.com.accera.mobile.tradeforceupdate.platform.di.module;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.data.appversion.repository.AppVersionRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.auth.repository.AuthRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.deploy.repository.DeployRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.drawermenu.repository.DrawerMenuRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.instance.repository.InstanceRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.permission.repository.PermissionRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.data.user.repository.UserRepositoryImpl;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import br.com.accera.mobile.tradeforceupdate.domain.auth.repository.AuthRepository;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.repository.DrawerMenuRepository;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import br.com.accera.mobile.tradeforceupdate.domain.permission.repository.PermissionRepository;
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
    abstract DrawerMenuRepository provideDrawerMenuRepository( DrawerMenuRepositoryImpl provider );

    @Binds
    abstract UserRepository provideUserRepository( UserRepositoryImpl provider );

    @Binds
    abstract AppVersionRepository provideAppVersionRepository( AppVersionRepositoryImpl provider );

    @Binds
    abstract InstanceRepository provideInstanceRepository( InstanceRepositoryImpl provider );

    @Binds
    abstract DeployRepository provideDeployRepository( DeployRepositoryImpl provider );

    @Binds
    abstract PermissionRepository providePermissionRepository(PermissionRepositoryImpl provider );

}
