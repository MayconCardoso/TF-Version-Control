package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import android.os.Bundle;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListAppVersionBinding;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class ListAppVersionActivity extends BaseMvvmActivity<ActivityListAppVersionBinding, ListAppVersionViewModel, ListAppVersionNavigator> {
    @Inject
    protected ListAppVersionAdapter mVersionAdapter;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
        setUpRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.getVersions();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_list_app_version;
    }

    private void registerObservables() {
        mViewModel.getObservable().mRegisterVersion.observe( this, ( __ ) -> mNavigator.goToRegisterVersion() );
        mViewModel.getObservable().mAppVersions.observe( this, mVersionAdapter::setVersions );
    }

    private void setUpRecyclerView() {
        RecyclerView recycler = mViewDataBinding.appRecycler;
        recycler.setLayoutManager(new LinearLayoutManager( this ));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(mVersionAdapter);
    }
}
