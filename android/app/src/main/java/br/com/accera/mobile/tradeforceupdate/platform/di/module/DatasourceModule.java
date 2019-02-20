package br.com.accera.mobile.tradeforceupdate.platform.di.module;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.data.appversion.datasource.AppVersionDatasource;
import br.com.accera.mobile.tradeforceupdate.data.appversion.datasource.AppVersionDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.auth.datasource.AuthDatasource;
import br.com.accera.mobile.tradeforceupdate.data.auth.datasource.AuthDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.deploy.datasource.DeployDatasource;
import br.com.accera.mobile.tradeforceupdate.data.deploy.datasource.DeployDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource.DrawerMenuDatasource;
import br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource.DrawerMenuDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.instance.datasource.InstanceDatasource;
import br.com.accera.mobile.tradeforceupdate.data.instance.datasource.InstanceDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.permission.datasource.PermissionDatasource;
import br.com.accera.mobile.tradeforceupdate.data.permission.datasource.PermissionDatasourceImpl;
import br.com.accera.mobile.tradeforceupdate.data.user.datasource.UserDatasource;
import br.com.accera.mobile.tradeforceupdate.data.user.datasource.UserDatasourceImpl;
import dagger.Binds;
import dagger.Module;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
@Module
public abstract class DatasourceModule {
    @Binds
    @Singleton
    abstract AuthDatasource provideAuthDatasource( AuthDatasourceImpl provider );

    @Binds
    abstract DrawerMenuDatasource provideDrawerMenuDatasource( DrawerMenuDatasourceImpl provider );

    @Binds
    abstract UserDatasource provideUserDatasource( UserDatasourceImpl provider );

    @Binds
    abstract AppVersionDatasource provideAppVersionDatasource( AppVersionDatasourceImpl provider );

    @Binds
    abstract InstanceDatasource provideInstanceDatasource( InstanceDatasourceImpl provider );

    @Binds
    abstract DeployDatasource provideDeployDatasource( DeployDatasourceImpl provider );

    @Binds
    abstract PermissionDatasource providePermissionDatasource(PermissionDatasourceImpl provider );
}
