package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.error.ErrorActivity;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public abstract class NavigatorImpl implements Navigator {
    private AppCompatActivity mActivity;

    public NavigatorImpl( AppCompatActivity activity ) {
        mActivity = activity;
    }

    @Override
    public final void onCleared() {
        mActivity = null;
    }

    @Override
    public void goToErrorScreen( String message ) {
        goToErrorScreen( "Atenção", message );
    }

    @Override
    public void goToErrorScreen( String title, String message ) {
        if(mActivity == null) return;
        if(title == null || message == null) throw new IllegalArgumentException("Values cannot be null");

        Bundle bundle = new Bundle();
        bundle.putString( ErrorActivity.TITLE, title );
        bundle.putString( ErrorActivity.MESSAGE, message );

        navigate( ErrorActivity.class, bundle, false);
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // PRIVATES
    //==============================================================================================
    protected void navigate( Class<? extends AppCompatActivity> subject) {
        navigate( subject, null, false );
    }

    protected void navigate( Class<? extends AppCompatActivity> subject, boolean finish ) {
        navigate( subject, null, finish );
    }

    protected void navigate( Class<? extends AppCompatActivity> subject, Bundle params, boolean finish ) {
        if(mActivity == null) return;

        Intent intent = new Intent( mActivity, subject );
        if( params != null ) {
            intent.putExtras( params );
        }
        mActivity.startActivity( intent );

        if(finish){
            mActivity.finish();
        }
    }
    //==============================================================================================

}
