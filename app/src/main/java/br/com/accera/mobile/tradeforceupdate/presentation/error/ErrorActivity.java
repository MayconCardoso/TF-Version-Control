package br.com.accera.mobile.tradeforceupdate.presentation.error;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import br.com.accera.mobile.tradeforceupdate.R;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class ErrorActivity extends AppCompatActivity {
    //==============================================================================================
    // CONSTANTES
    //==============================================================================================
    public static final String TITLE = "";
    public static final String MESSAGE = "";
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // IMP
    //==============================================================================================
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_error );
    }
}
