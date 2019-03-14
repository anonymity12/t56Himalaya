package com.example.paul.t56himalaya.fragments;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paul.t56himalaya.R;
import com.example.paul.t56himalaya.adapters.RecommendListAdapter;
import com.example.paul.t56himalaya.base.BaseFragment;
import com.example.paul.t56himalaya.utils.Constants;
import com.example.paul.t56himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2019/3/7
 * last modified at 22:02.
 * Desc:
 */

public class RecommendFragment extends BaseFragment {
    private static final String TAG = "RecommendFragment";
    private RecyclerView mRecommendRv;
    private RecommendListAdapter recommendListAdapter;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        // s1 get view
        View rootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);
        mRecommendRv = rootView.findViewById(R.id.recommend_list);
        // s1 set layout mgr
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecommendRv.setLayoutManager(linearLayoutManager);

        recommendListAdapter = new RecommendListAdapter();
        mRecommendRv.setAdapter(recommendListAdapter);

        // s2 get data
        getRecommendData();
        return rootView;
    }

    /**
     * file:///Users/paul/Downloads/sourceCode/XimalayaAndroidSDK_6.2.5/%E5%96%9C%E9%A9%AC%E6%8B%89%E9%9B%85SDK%E6%8E%A5%E5%85%A5%E6%96%87%E6%A1%A3.html
     * 3.10.6 获取猜你喜欢专辑
     */
    private void getRecommendData() {
        // encap the param
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.LIKE_COUNT, Constants.RECOMMEND_COUNT + "");
        CommonRequest.getGuessLikeAlbum(map, new IDataCallBack<GussLikeAlbumList>() {
            @Override
            public void onSuccess(@Nullable GussLikeAlbumList gussLikeAlbumList) {
                LogUtil.d(TAG," thread name --> " + Thread.currentThread().getName());
                if (gussLikeAlbumList != null) {
                    List<Album> albumList = gussLikeAlbumList.getAlbumList();
                    if (albumList != null) {
                        LogUtil.d(TAG, "got! size --- >" + albumList.size());
                        // 数据回来之后，我们要用adapter 更新view（更新UI，发生在主线程）
                        upRecommendUI(albumList);
                    }
                }
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.d(TAG, "error --> " + s);

            }
        });
    }

    private void upRecommendUI(List<Album> albumList) {
        recommendListAdapter.setData(albumList);
    }
}
