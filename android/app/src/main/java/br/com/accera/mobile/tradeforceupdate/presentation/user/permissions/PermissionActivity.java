package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityPermissionBinding;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionActivity extends BaseMvvmActivity<ActivityPermissionBinding, PermissionViewModel, PermissionNavigator> {

    @Inject
    protected PermissionAdapter mAdapter;
    private User mUser;

    @Override
    public int getLayoutId() {
        return R.layout.activity_permission;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerObservables();
        setUpRecyclerView();



        mViewModel.setUser(getUser());
        mViewModel.loadPermissions();

    }

    private void setUpRecyclerView() {
        RecyclerView permissionList = mViewDataBinding.permissionList;
        permissionList.setLayoutManager(new LinearLayoutManager(this));
        permissionList.setItemAnimator(new DefaultItemAnimator());
        permissionList.setAdapter(mAdapter);
    }

    private void registerObservables() {
        mViewModel.getObservable().mPermissions.observe(this, mAdapter::setItens);
        mViewModel.getObservable().mGoBack.observe(this, (__)-> onBackPressed());
    }

    private User getUser() {
        if(mUser == null){
            mUser = (User) getIntent().getExtras().getSerializable( "USER" );
        }
        return mUser;
    }
}
