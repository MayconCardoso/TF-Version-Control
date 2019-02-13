package br.com.accera.mobile.tradeforceupdate.common.platform.util;

import android.app.Application;


/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class ResourceUtil {
    private Application mApplication;

    public ResourceUtil( Application application ) {
        mApplication = application;
    }

    public String getString( int resId ) {
        return mApplication.getString( resId );
    }

    public String getString( int resId, Object... formatArgs ) {
        return mApplication.getString( resId, formatArgs );
    }
}
