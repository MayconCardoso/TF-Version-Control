package br.com.accera.mobile.tradeforceupdate.presentation.deploy.schedule;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import javax.annotation.Nullable;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityScheduleDeployBinding;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class ScheduleDeployActivity extends BaseMvvmActivity<ActivityScheduleDeployBinding, ScheduleDeployViewModel, ScheduleDeployNavigator> {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        mViewDataBinding.toolbar.setTitle(R.string.title_screen_schedule_deploy);
        registerObservables();
        registerListeners();
        mViewModel.loadVersions();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_schedule_deploy;
    }

    private void registerObservables() {
        mViewModel.getObservable().mBack.observe( this, ( __ ) -> onBackPressed() );
        mViewModel.getObservable().mAppVersions.observe( this, appVersions ->
                mViewDataBinding.spVersaoAtual.setAdapter( new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, appVersions
                ) )
        );
    }

    private void registerListeners() {
        mViewDataBinding.rgUpdateType.setOnCheckedChangeListener( ( radioGroup, viewId ) ->
                mViewModel.getState().mUpdateTypeByGroup.set(
                        viewId == mViewDataBinding.rbByGroup.getId()
                ) );
    }

    public void scheduleDeploy( View view ) {
        mViewModel.register(
                getSelectedAppVersion(),
                mViewDataBinding.etDaysNecessary.getText().toString(),
                mViewDataBinding.etInitialPercent.getText().toString(),
                mViewDataBinding.etCountDeploys.getText().toString()
        );
    }

    private AppVersion getSelectedAppVersion() {
        return (AppVersion) mViewDataBinding.spVersaoAtual.getSelectedItem();
    }
}
