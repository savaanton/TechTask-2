package ua.antonsava.secondapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabFragment extends Fragment {
    public static TabLayout sTabLayout; //[Comment] Why static? Do you know what word "static" means?
    public static ViewPager sViewPager; //[Comment] Why static? Do you know what word "static" means?
    public static int sIntItems = 3;    //[Comment] Use upper-case for constant names

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View maket = inflater.inflate(R.layout.tab_layout, null); //[Comment] maket - wrong name
        sTabLayout = (TabLayout) maket.findViewById(R.id.tabs);
        sViewPager = (ViewPager) maket.findViewById(R.id.view_pager);

        sViewPager.setAdapter(new Adapter(getChildFragmentManager()));

        sTabLayout.post(new Runnable() { //[Comment] Unnecessary runnable
            @Override
            public void run() {
                sTabLayout.setupWithViewPager(sViewPager);
            }
        });
        return maket;
    }

    class Adapter extends FragmentPagerAdapter { //[Comment] Should be external
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0://[Comment] Magic numbers
                    return new MakesFragment(); //[Comment] Use newInstance pattern for fragments
                case 1://[Comment] Magic numbers
                    return new DoneFragment(); //[Comment] Use newInstance pattern for fragments
                case 2://[Comment] Magic numbers
                    return new WaitFragment(); //[Comment] Use newInstance pattern for fragments
            }
            return null;
        }

        @Override
        public int getCount() {
            return sIntItems;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: //[Comment] Magic numbers
                    return "Проведення"; //[Comment] HardCode
                case 1: //[Comment] Magic numbers
                    return "Нещодавно відбулися"; //[Comment] HardCode
                case 2: //[Comment] Magic numbers
                    return "Найближчі події"; //[Comment] HardCode
            }
            return null;
        }
    }
}

