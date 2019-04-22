package com.example.paul.t56himalaya.fragments;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paul.t56himalaya.R;
import com.example.paul.t56himalaya.adapters.RecommendListAdapter;
import com.example.paul.t56himalaya.base.BaseFragment;
import com.example.paul.t56himalaya.interfaces.IRecommendViewCallback;
import com.example.paul.t56himalaya.presenters.RecommendPresenter;
import com.example.paul.t56himalaya.utils.Constants;
import com.example.paul.t56himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2019/3/7
 * last modified at 22:02.
 * Desc: 推荐页面，mvp 中的view
 */

public class RecommendFragment extends BaseFragment implements IRecommendViewCallback {
    private static final String TAG = "RecommendFragment";
    private RecyclerView mRecommendRv;
    private RecommendListAdapter recommendListAdapter;
    private RecommendPresenter mPresenter;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        // s1 get view
        View rootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);
        mRecommendRv = rootView.findViewById(R.id.recommend_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecommendRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = UIUtil.dip2px(view.getContext(), 10);
                outRect.top = UIUtil.dip2px(view.getContext(), 10);
                outRect.left = UIUtil.dip2px(view.getContext(), 10);
                outRect.right = UIUtil.dip2px(view.getContext(), 10);
            }
        });
        mRecommendRv.setLayoutManager(linearLayoutManager);


        recommendListAdapter = new RecommendListAdapter();
        mRecommendRv.setAdapter(recommendListAdapter);

        mPresenter = RecommendPresenter.getsInstance();
        mPresenter.registerViewCallback(this);
        mPresenter.getRecommendList();

        return rootView;
    }


    @Override
    public void onRecommendListLoad(List<Album> result) {
        recommendListAdapter.setData(result);
    }

    @Override
    public void onLoadMore(List<Album> result) {

    }

    @Override
    public void onRefreshMore(List<Album> result) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unRegisterViewCallback(this);

    }
}
