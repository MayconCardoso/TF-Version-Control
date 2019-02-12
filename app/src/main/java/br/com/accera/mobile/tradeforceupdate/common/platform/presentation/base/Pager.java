package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base;

import androidx.fragment.app.Fragment;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class Pager {
    private String mTitle;
    private Fragment mFragment;

    private Pager( String title, Fragment fragment ) {
        mTitle = title;
        mFragment = fragment;
    }

    public String getTitle() {
        return mTitle;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public static Pager create( String title, Fragment fragment ) {
        return new Pager( title, fragment );
    }
}
