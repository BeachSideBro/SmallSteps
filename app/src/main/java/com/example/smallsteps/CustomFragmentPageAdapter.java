package com.example.smallsteps;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_COUNT = 2;

    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
                return new TasksToDoFragment();
            case 1:
                return new TasksCompletedFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "To-DO";
            case 1:
                return "Completed";
        }

        return null;
    }
}
