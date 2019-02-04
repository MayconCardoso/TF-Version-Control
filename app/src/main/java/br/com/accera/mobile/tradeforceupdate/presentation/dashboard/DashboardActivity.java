package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import javax.annotation.Nullable;
import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityDashboardBinding;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.list.ListAppVersionActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuComponent;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.register.RegisterInstanceActivity;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class DashboardActivity extends BaseMvvmActivity<ActivityDashboardBinding, DashboardViewModel, DashboardNavigator> {
    @Inject
    DrawerMenuComponent mDrawerMenuComponent;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.dashboard_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        if( item.getItemId() == R.id.logout ) {
            mViewModel.tryLogout();
        }
        return super.onOptionsItemSelected( item );
    }

    private void registerObservables() {
        // Register drawer menu component on life cycle.
        getLifecycle().addObserver( mDrawerMenuComponent );
        // Navigator
        mViewModel.getObservable().mAuthScreen.observe( this, ( __ ) -> mNavigator.goToLogin() );
    }

    public void registerVersion( View view ) {
        // TODO: 30/01/2019 remove
        startActivity( new Intent( this, ListAppVersionActivity.class ) );
    }

    public void registerClient( View view ) {
        // TODO: 30/01/2019 remove
        startActivity( new Intent( this, RegisterInstanceActivity.class ) );
    }
}