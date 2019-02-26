package br.com.accera.mobile.tradeforceupdate.presentation.appversion.register;

import android.os.Bundle;
import android.view.View;

import javax.annotation.Nullable;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityRegisterAppVersionBinding;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class RegisterAppVersionActivity extends BaseMvvmActivity<ActivityRegisterAppVersionBinding, RegisterAppVersionViewModel, RegisterAppVersionNavigator> {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        mViewDataBinding.toolbar.setTitle(R.string.title_screen_register_app_version);
        registerObservables();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_app_version;
    }

    private void registerObservables() {
        mViewModel.getObservable().mBack.observe( this, ( __ ) -> onBackPressed() );
    }

    public void registerAppVersion( View view ) {
        mViewModel.register(
                mViewDataBinding.etVersionCode.getText().toString(),
                mViewDataBinding.etVersionName.getText().toString(),
                mViewDataBinding.etLink.getText().toString()
        );
    }
}
