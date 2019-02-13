package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import android.os.Bundle;
import android.view.View;

import javax.annotation.Nullable;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityRegisterUserBinding;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class RegisterUserActivity extends BaseMvvmActivity<ActivityRegisterUserBinding, RegisterUserViewModel, RegisterUserNavigator> {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_user;
    }

    private void registerObservables() {
        mViewModel.getObservable().mWaitingApprovement.observe(
                this,
                user -> mNavigator.goToWaitingAproveScreen( user )
        );
    }

    public void requestSystemAccess( View view ) {
        mViewModel.requestSystenAccess(
                mViewDataBinding.etFirstName.getText().toString(),
                mViewDataBinding.etLastName.getText().toString(),
                mViewDataBinding.etEmail.getText().toString(),
                mViewDataBinding.etPassword.getText().toString(),
                mViewDataBinding.etConfirmPassword.getText().toString()
        );
    }
}
