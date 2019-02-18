package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityNeedApprovementBinding;

public class NeedApprovementActivity extends BaseMvvmActivity<ActivityNeedApprovementBinding, NeedApprovementViewModel, NeedApprovementNavigator> {

    @Inject
    protected NeedApprovementAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_need_approvement;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerObservables();
        setUpRecyclerView();

        mAdapter.setEvent(item -> mViewModel.changeUserAuthorization(item));

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
        mViewModel.getObservable().mApprove.observe(this, this::showToastUserApproved);
    }

    private void showToastUserApproved(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
