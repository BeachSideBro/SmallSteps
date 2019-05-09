package com.example.smallsteps;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TaskFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;

    @RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks,container,false);

        appBarLayout = (AppBarLayout)view.findViewById(R.id.appbar);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs_tasks);
        viewPager = (ViewPager)view.findViewById(R.id.container_tabs);
        viewPager.setAdapter(new CustomFragmentPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }
}
