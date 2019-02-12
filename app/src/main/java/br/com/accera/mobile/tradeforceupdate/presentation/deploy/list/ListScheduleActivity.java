package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.viewpager.widget.ViewPager;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListScheduleBinding;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class ListScheduleActivity extends BaseMvvmActivity<ActivityListScheduleBinding, ListScheduleViewModel, ListScheduleNavigator> {

    @Inject
    protected ListScheduleFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setSupportActionBar(mViewDataBinding.toolbar);
        registerObservables();
        setupViewPager();

        // Load itens
        mViewModel.loadVersions();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.add_menu, menu );
        inflater.inflate( R.menu.calendar_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        if( item.getItemId() == R.id.add ) {
            mViewModel.goToRegisterPage();
        }
        else if( item.getItemId() == R.id.calendar ) {
            showFilterDialog();
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_schedule;
    }

    private void registerObservables() {
        mViewModel.getObservable().mRegister.observe( this, (__) -> mNavigator.goToRegisterSchecule() );
        mViewModel.getObservable().mSchedule.observe( this, this::onScheduleFound);
    }

    private void setupViewPager() {
        ViewPager viewPager = mViewDataBinding.viewpager;
        viewPager.setAdapter( mPagerAdapter );

        mViewDataBinding.slidingTabs.setupWithViewPager( viewPager );
    }

    private void onScheduleFound( ScheduleDeploy scheduleDeploy ) {
        // Set instances
        mPagerAdapter.setDeploy( scheduleDeploy );
        mPagerAdapter.notifyDataSetChanged();

        // Set version
        mViewDataBinding.itemVersion.setItem( scheduleDeploy.getVersion() );
    }

    private void showFilterDialog() {

    }
}
