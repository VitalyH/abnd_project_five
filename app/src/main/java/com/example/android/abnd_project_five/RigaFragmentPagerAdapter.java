package com.example.android.abnd_project_five;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate Fragment for a view pager.
 */
public class RigaFragmentPagerAdapter extends FragmentPagerAdapter {

    @SuppressWarnings("FieldCanBeLocal")

    final private int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3", "Tab4" };

    public RigaFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopSightsFragment();
        } else if (position == 1){
            return new WineDineFragment();
        } else if (position == 2) {
            return new BarsClubsFragment();
        } else {
            return new WithKidsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


}