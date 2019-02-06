package br.com.accera.mobile.tradeforceupdate.platform.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.ViewModelFactory;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.ViewModelKey;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.list.ListAppVersionViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.register.RegisterAppVersionViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.auth.AuthViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule.ScheduleDeployViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.list.ListInstanceViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.register.RegisterInstanceViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.splash.SplashViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.user.register.RegisterUserViewModel;
import br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement.WaitingApprovementViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    //==============================================================================================
    // FACTORY
    //==============================================================================================
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory( ViewModelFactory factory );

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // INSTANCES
    //==============================================================================================
    @Binds
    @IntoMap
    @ViewModelKey( AuthViewModel.class )
    abstract ViewModel bindAuthViewModel( AuthViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( SplashViewModel.class )
    abstract ViewModel bindSplashViewModel( SplashViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( DashboardViewModel.class )
    abstract ViewModel bindDashboardViewModel( DashboardViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( RegisterUserViewModel.class )
    abstract ViewModel bindRegisterUserViewModel( RegisterUserViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( WaitingApprovementViewModel.class )
    abstract ViewModel bindWaitingApprovementViewModel( WaitingApprovementViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( DrawerMenuViewModel.class )
    abstract ViewModel bindDrawerMenuViewModel( DrawerMenuViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( RegisterAppVersionViewModel.class )
    abstract ViewModel bindRegisterAppVersionViewModel( RegisterAppVersionViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( ListAppVersionViewModel.class )
    abstract ViewModel bindListAppVersionViewModel( ListAppVersionViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( RegisterInstanceViewModel.class )
    abstract ViewModel bindRegisterInstanceViewModel( RegisterInstanceViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( ListInstanceViewModel.class )
    abstract ViewModel bindListInstanceViewModel( ListInstanceViewModel viewModel );

    @Binds
    @IntoMap
    @ViewModelKey( ScheduleDeployViewModel.class )
    abstract ViewModel bindRegisterCalendarViewModel( ScheduleDeployViewModel viewModel );

}