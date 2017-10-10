package com.example.andrearodriguez.redessociales.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.andrearodriguez.redessociales.BaseFragment;

/**
 * Created by andrearodriguez on 10/6/17.
 */

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    public BaseViewPagerAdapter(FragmentManager manager, String[] tabs) {
        super(manager);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseFragment.getInstance(tabs[position]);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
