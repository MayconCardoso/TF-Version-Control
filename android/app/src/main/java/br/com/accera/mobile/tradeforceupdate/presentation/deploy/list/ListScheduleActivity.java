package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.ViewPager;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListScheduleBinding;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
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
        setSupportActionBar( mViewDataBinding.toolbar );
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
        } else if( item.getItemId() == R.id.calendar ) {
            onShowFilterDialogClicked();
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_schedule;
    }

    private void registerObservables() {
        mViewModel.getObservable().mRegister.observe( this, ( __ ) -> mNavigator.goToRegisterSchecule() );
        mViewModel.getObservable().mSchedule.observe( this, this::onScheduleFound );
    }

    private void setupViewPager() {
        ViewPager viewPager = mViewDataBinding.viewpager;
        viewPager.setAdapter( mPagerAdapter );
        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels ) {
            }

            @Override
            public void onPageSelected( int position ) {
                ScheduleDeploy schedule = mViewModel.getObservable().mSchedule.getValue();
                if(schedule == null){
                    return;
                }
                mViewModel.setSelectedDeploy( schedule.getDeploys().get( position ) );
            }

            @Override
            public void onPageScrollStateChanged( int state ) {
            }
        } );
        mViewDataBinding.slidingTabs.setupWithViewPager( viewPager );
    }

    private void onScheduleFound( ScheduleDeploy scheduleDeploy ) {
        // Set instances
        mPagerAdapter.clear();
        mPagerAdapter.setDeploy( scheduleDeploy );
        mPagerAdapter.notifyDataSetChanged();

        // Set version
        mViewDataBinding.itemVersion.setItem( scheduleDeploy.getVersion() );
        mViewDataBinding.itemVersion.tvAction.setText( R.string.action_publish );
        mViewDataBinding.itemVersion.tvAction.setOnClickListener( view -> showPublishConfirmation() );
    }

    private void showPublishConfirmation() {
        final Deploy deploy = mViewModel.getState().mCurrentDeploy.get();
        if(deploy == null){
            Toast.makeText( this, "Algo inesperado aconteceu.", Toast.LENGTH_SHORT ).show();
            return;
        }

        // Message
        String message = String.format(
                "Deseja publicar a versão %s do dia %s?",
                deploy.getVersion().getVersionName(),
                deploy.getDate()
        );

        new AlertDialog.Builder( this )
                .setTitle( "Confirmação" )
                .setMessage( message )
                .setPositiveButton( "SIM", ( dialogInterface, i ) -> mViewModel.doDeploy( deploy ) )
                .setNegativeButton( "NÃO", null );
    }

    private void onShowFilterDialogClicked() {
        // Get all versions
        List<AppVersion> versions = mViewModel.getObservable().mAppVersions.getValue();
        if( versions == null || versions.isEmpty() ) {
            return;
        }

        // Ger the checked one.
        AppVersion selected = mViewModel.getState().mSelectedVersion.get();
        if( selected == null ) {
            selected = versions.get( 0 );
        }

        // Array with titles.
        CharSequence[] titles = new CharSequence[versions.size()];
        int positionCheckedItem = 0;

        // Create array
        for ( int position = 0; position < versions.size(); position++ ) {
            AppVersion current = versions.get( position );
            titles[position] = current.getVersionName();

            if( current.getVersionCode() == selected.getVersionCode() ) {
                positionCheckedItem = position;
            }

        }

        // Show dialog.
        new AlertDialog.Builder( this )
                .setTitle( getString( R.string.get_a_version) )
                .setCancelable( false )
                .setSingleChoiceItems(
                        titles,
                        positionCheckedItem,
                        ( dialogInterface, position ) -> {
                            mViewModel.setSelectedVersion( versions.get( position ) );
                            dialogInterface.dismiss();
                        }
                ).show();
    }
}
