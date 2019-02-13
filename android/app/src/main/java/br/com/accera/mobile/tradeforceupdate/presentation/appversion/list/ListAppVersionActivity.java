package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

        mViewModel.getVersions();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.add_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        if( item.getItemId() == R.id.add ) {
            mViewModel.goToRegisterPage();
        }
        return super.onOptionsItemSelected( item );
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
