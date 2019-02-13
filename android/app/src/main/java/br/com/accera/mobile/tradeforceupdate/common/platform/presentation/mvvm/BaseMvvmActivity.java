package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import br.com.accera.mobile.tradeforceupdate.BR;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base.BaseCompactActivity;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation.Navigator;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.KeyboardUtils;
import dagger.android.AndroidInjection;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public abstract class BaseMvvmActivity<VDB extends ViewDataBinding, VM extends BaseObservableViewModel, NAVIGATOR extends Navigator> extends BaseCompactActivity {
    //==============================================================================================
    // OBJECTS
    //==============================================================================================
    protected VDB mViewDataBinding;
    @Inject
    protected VM mViewModel;
    @Inject
    protected NAVIGATOR mNavigator;

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // ABSTRACTS
    //==============================================================================================
    public abstract @LayoutRes
    int getLayoutId();
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // LYFE-CYCLE
    //==============================================================================================
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        performDependencyInjection();
        super.onCreate( savedInstanceState );
        performDataBinding();
        setupLiveDataSources();
    }


    @Override
    protected void onDestroy() {
        if( mNavigator != null ) mNavigator.onCleared();
        super.onDestroy();
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // LIVEDATA
    //==============================================================================================

    private void setupLiveDataSources() {
        mViewModel.getAlertFeedback().observe( this, (AlertMessage.MessageObserver) builder ->
                new AlertDialog.Builder( this )
                        .setTitle( builder.getTitle( this ) )
                        .setMessage( builder.getMessage( this ) )
                        .show() );

        mViewModel.getHideKeyboard().observe( this, () -> KeyboardUtils.hideSoftInput(
                BaseMvvmActivity.this
        ) );
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODS
    //==============================================================================================

    protected int getBindingVariable() {
        return BR.viewModel;
    }

    private void performDependencyInjection() {
        AndroidInjection.inject( this );
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView( this, getLayoutId() );
        mViewDataBinding.setLifecycleOwner( this );
        mViewDataBinding.setVariable( getBindingVariable(), mViewModel );
        mViewDataBinding.executePendingBindings();
    }
    //==============================================================================================
}
