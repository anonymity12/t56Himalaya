package com.example.paul.t56himalaya.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.paul.t56himalaya.utils.FragmentCreator;

/**
 * Created by paul on 2019/3/7
 * last modified at 21:50.
 * Desc:
 */

public class MainContentAdapter extends FragmentPagerAdapter {
    public MainContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentCreator.getFragment(position);
    }

    @Override
    public int getCount() {
        return FragmentCreator.PAGE_COUNT;
    }
}
