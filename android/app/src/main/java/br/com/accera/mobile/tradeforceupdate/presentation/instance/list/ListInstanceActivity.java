package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivityDrawer;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityListInstanceBinding;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class ListInstanceActivity extends BaseMvvmActivityDrawer<ActivityListInstanceBinding, ListInstanceViewModel, ListInstanceNavigator> {
    @Inject
    protected ListInstanceAdapter mAdapter;

    @Override
    protected Toolbar getToolbar() {
        return mViewDataBinding.toolbar;
    }

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
        setUpRecyclerView();


        // Set event on adapter
        mAdapter.setEvent( mViewModel::editInstance );

        // Load itens
        mViewModel.loadInstances();
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
        return R.layout.activity_list_instance;
    }

    private void registerObservables() {
        mViewModel.getObservable().mRegister.observe( this, mNavigator::goToRegisterInstance );
        mViewModel.getObservable().mItens.observe( this, mAdapter::setItens );
    }

    private void setUpRecyclerView() {
        RecyclerView recycler = mViewDataBinding.appRecycler;
        recycler.setLayoutManager( new LinearLayoutManager( this ) );
        recycler.setItemAnimator( new DefaultItemAnimator() );
        recycler.setAdapter( mAdapter );
    }
}
