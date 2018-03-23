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

    public RigaFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // Get right fragments.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopSightsFragment();
        } else if (position == 1) {
            return new WineDineFragment();
        } else if (position == 2) {
            return new BarsClubsFragment();
        } else {
            return new WithKidsFragment();
        }
    }

    // Generate title based on item position.
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {

            case 0:
                return App.context().getString(R.string.category_top_sights);

            case 1:
                return App.context().getString(R.string.category_wine_dine);

            case 2:
                return App.context().getString(R.string.category_bars_clubs);

            case 3:
                return App.context().getString(R.string.category_with_kids);
        }

        return null;
    }
}