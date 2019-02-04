package br.com.accera.mobile.tradeforceupdate.platform.di.builder;

import br.com.accera.mobile.tradeforceupdate.presentation.appversion.list.ListAppVersionActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.list.ListAppVersionModule;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.register.RegisterAppVersionActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.register.RegisterAppVersionModule;
import br.com.accera.mobile.tradeforceupdate.presentation.auth.AuthActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.auth.AuthActivityModule;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivityModule;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuModule;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.register.RegisterInstanceActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.register.RegisterInstanceModule;
import br.com.accera.mobile.tradeforceupdate.presentation.splash.SplashActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.splash.SplashActivityModule;
import br.com.accera.mobile.tradeforceupdate.presentation.user.register.RegisterUserActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.user.register.RegisterUserActivityModule;
import br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement.WaitingApprovementActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement.WaitingApprovementActivityModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector( modules = {AuthActivityModule.class} )
    abstract AuthActivity bindLoginActivity();

    @ContributesAndroidInjector( modules = {SplashActivityModule.class} )
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector( modules = {DashboardActivityModule.class, DrawerMenuModule.class} )
    abstract DashboardActivity bindDashboardActivity();

    @ContributesAndroidInjector( modules = {WaitingApprovementActivityModule.class} )
    abstract WaitingApprovementActivity bindWaitingApprovementActivity();

    @ContributesAndroidInjector( modules = {RegisterUserActivityModule.class} )
    abstract RegisterUserActivity bindRegisterUserActivity();

    @ContributesAndroidInjector( modules = {RegisterAppVersionModule.class} )
    abstract RegisterAppVersionActivity bindRegisterAppVersionActivity();

    @ContributesAndroidInjector( modules = {ListAppVersionModule.class} )
    abstract ListAppVersionActivity bindListAppVersionActivity();

    @ContributesAndroidInjector( modules = {RegisterInstanceModule.class} )
    abstract RegisterInstanceActivity bindRegisterInstanceActivity();
}