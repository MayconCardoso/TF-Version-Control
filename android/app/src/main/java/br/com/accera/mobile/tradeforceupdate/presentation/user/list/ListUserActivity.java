package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListUserBinding;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuComponent;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class ListUserActivity extends BaseMvvmActivity<ActivityListUserBinding, ListUserViewModel, ListUserNavigator> {

    @Inject
    protected ListUserAdapter mAdapter;

    @Inject
    protected DrawerMenuComponent mDrawerMenuComponent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerObservables();
        setUpRecyclerView();

        mAdapter.setEvent(getAdapterClicks());

        mViewModel.loadUsers();

        setSupportActionBar(mViewDataBinding.toolbar);


    }

    private void setUpRecyclerView() {
        RecyclerView approvementRecycler = mViewDataBinding.approvementRecycler;
        approvementRecycler.setLayoutManager( new LinearLayoutManager(this));
        approvementRecycler.setItemAnimator(new DefaultItemAnimator());
        approvementRecycler.setAdapter(mAdapter);
    }

    private void registerObservables() {
        getLifecycle().addObserver( mDrawerMenuComponent );
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
