package ua.antonsava.secondapp;

import android.content.res.ColorStateList;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabFragment extends Fragment {
    public TabLayout tabLayout;
    public ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_layout, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.makes)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.done)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.wait)));

        List<Fragment> fragments = new ArrayList<>(3);

        fragments.add(MakesFragment.getInstance(State.STATUS_MAKES));
        fragments.add(MakesFragment.getInstance(State.STATUS_DONE));
        fragments.add(WaitFragment.getInstance(State.STATUS_WAIT));


        viewPager.setAdapter(new Adapter(getChildFragmentManager(), tabLayout.getTabCount(), fragments));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}



