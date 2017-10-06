package com.example.andrearodriguez.redessociales.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by andrearodriguez on 10/6/17.
 */

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    private String[] descriptions;

    public BaseViewPagerAdapter(FragmentManager manager, String[] tabs, String[] descriptions) {
        super(manager);
        this.tabs = tabs;
        this.descriptions = descriptions;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
