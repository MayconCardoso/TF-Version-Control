package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.presentation.drawermenu.DrawerMenuComponent;

/**
 * Created by Rafael Spitaliere on 21/02/19.
 */
public abstract class BaseMvvmActivityDrawer<VDB extends ViewDataBinding, VM extends BaseObservableViewModel, NAVIGATOR extends Navigator> extends BaseMvvmActivity<VDB, VM, NAVIGATOR> {

    @Inject
    protected DrawerMenuComponent mDrawerMenuComponent;

    protected abstract Toolbar getToolbar();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportToolbar();
        setLifeCycle();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerMenuComponent.isDrawerOpen()){
            mDrawerMenuComponent.closeDrawer();
            return;
        }
        super.onBackPressed();
    }

    private void setLifeCycle() {
        getLifecycle().addObserver( mDrawerMenuComponent );
    }

    private void setSupportToolbar() {
        setSupportActionBar(getToolbar());
    }
}
