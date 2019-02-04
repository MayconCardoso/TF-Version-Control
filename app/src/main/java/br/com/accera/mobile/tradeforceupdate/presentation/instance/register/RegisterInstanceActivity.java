package br.com.accera.mobile.tradeforceupdate.presentation.instance.register;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import javax.annotation.Nullable;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseMvvmActivity;
import br.com.accera.mobile.tradeforceupdate.databinding.ActivityRegisterInstanceBinding;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class RegisterInstanceActivity extends BaseMvvmActivity<ActivityRegisterInstanceBinding, RegisterInstanceViewModel, RegisterInstanceNavigator> {

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        registerObservables();
        mViewModel.loadVersions();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_register_instance;
    }

    private void registerObservables() {
        mViewModel.getObservable().mBack.observe( this, ( __ ) -> onBackPressed() );
        mViewModel.getObservable().mAppVersions.observe( this, appVersions ->
                mViewDataBinding.spVersaoAtual.setAdapter( new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, appVersions
                ) )
        );
    }

    public void registerInstance( View view ) {
    }
}
