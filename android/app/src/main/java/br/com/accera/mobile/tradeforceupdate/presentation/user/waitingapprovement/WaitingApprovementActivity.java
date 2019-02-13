package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import android.os.Bundle;
import android.view.View;

import javax.annotation.Nullable;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityWaitingApprovementBinding;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class WaitingApprovementActivity extends BaseMvvmActivity<ActivityWaitingApprovementBinding, WaitingApprovementViewModel, WaitingApprovementNavigator> {
    private User mUser = null;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
        mViewModel.init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.observeUser( getUser() );
    }

    @Override
    protected void onStop() {
        mViewModel.cancelUserObserver();
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_waiting_approvement;
    }

    private User getUser() {
        if(mUser == null){
            mUser = (User) getIntent().getExtras().getSerializable( "USER" );
        }
        return mUser;
    }

    private void registerObservables() {
        mViewModel.getObservable().mDashboardNavigation.observe( this, (__) -> mNavigator.goToDashboard());
    }

    public void goToDashboard( View view ) {
        mViewModel.getObservable().mDashboardNavigation.call();
    }
}
