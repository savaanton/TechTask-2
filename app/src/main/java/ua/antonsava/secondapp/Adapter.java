package ua.antonsava.secondapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Apple on 05.05.2016.
 */
public class Adapter extends FragmentPagerAdapter {
    int mTabNumber;
    private List<Fragment> mFragments;

    public Adapter(FragmentManager fm, int tabCount, List<Fragment> fragments) {
        super(fm);
        this.mTabNumber = tabCount;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabNumber;
    }
}
