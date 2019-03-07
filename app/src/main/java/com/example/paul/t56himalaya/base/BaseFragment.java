package com.example.paul.t56himalaya.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paul on 2019/3/7
 * last modified at 22:02.
 * Desc:
 */

public abstract class BaseFragment extends Fragment {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = onSubViewLoaded(inflater, container);
        return mRootView;
    }

    protected abstract View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container);
}
