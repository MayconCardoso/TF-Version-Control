package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<Pager> mPages = new ArrayList<>();

    public BaseFragmentPagerAdapter( FragmentManager fm ) {
        super( fm );
    }

    @Override
    public Fragment getItem( int position ) {
        return mPages.get( position ).getFragment();
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle( int position ) {
        return mPages.get( position ).getTitle();
    }

    public void clear() {
        mPages.clear();
        notifyDataSetChanged();
    }

    public void add( Pager pager ) {
        mPages.add( pager );
    }
}
