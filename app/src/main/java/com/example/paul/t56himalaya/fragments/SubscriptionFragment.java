package com.example.paul.t56himalaya.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paul.t56himalaya.R;
import com.example.paul.t56himalaya.base.BaseFragment;

/**
 * Created by paul on 2019/3/7
 * last modified at 22:03.
 * Desc:
 */

public class SubscriptionFragment extends BaseFragment {
    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View rootView = layoutInflater.inflate(R.layout.fragment_subscription, container, false);
        return rootView;
    }
}
