package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public abstract class BaseCompactActivity extends AppCompatActivity {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        // Bug das imagens.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate( savedInstanceState );
    }
}
