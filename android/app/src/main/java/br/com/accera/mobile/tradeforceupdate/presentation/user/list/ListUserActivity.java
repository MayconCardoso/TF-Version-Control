package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivityDrawer;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListUserBinding;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class ListUserActivity extends BaseMvvmActivityDrawer<ActivityListUserBinding, ListUserViewModel, ListUserNavigator> {

    @Inject
    protected ListUserAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_user;
    }

    @Override
    protected Toolbar getToolbar() {
        return mViewDataBinding.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerObservables();
        setUpRecyclerView();

        mAdapter.setEvent(getAdapterClicks());

        mViewModel.loadUsers();
    }

    private void setUpRecyclerView() {
        RecyclerView approvementRecycler = mViewDataBinding.approvementRecycler;
        approvementRecycler.setLayoutManager( new LinearLayoutManager(this));
        approvementRecycler.setItemAnimator(new DefaultItemAnimator());
        approvementRecycler.setAdapter(mAdapter);
    }

    private void registerObservables() {
        mViewModel.getObservable().mUsers.observe(this, mAdapter::setItens);
        mViewModel.getObservable().mUserToPermission.observe(this,  mNavigator::goToPermissions);
        mViewModel.getObservable().mApprove.observe(this, this::showToastUserApproved);
    }

    private void showToastUserApproved(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private ListUserAdapter.Event getAdapterClicks(){
       return new ListUserAdapter.Event() {
            @Override
            public void setUserAccess(User item) {
                mViewModel.changeUserAuthorization(item);
            }

            @Override
            public void setUserPermission(User item) {
                mViewModel.setUserPermissionNavigation(item);
            }
        };
    }
}
