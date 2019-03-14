package com.example.paul.t56himalaya.presenters;

import android.support.annotation.Nullable;

import com.example.paul.t56himalaya.interfaces.IRecommendPresenter;
import com.example.paul.t56himalaya.interfaces.IRecommendViewCallback;
import com.example.paul.t56himalaya.utils.Constants;
import com.example.paul.t56himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2019/3/14
 * last modified at 13:47.
 * Desc:
 */

public class RecommendPresenter implements IRecommendPresenter {

    private static final String TAG = "RecommendPresenter";
    private List<IRecommendViewCallback> mCallbacks = new ArrayList<>();
    /*懒汉单例*/

    private static RecommendPresenter sInstance = null;

    public static RecommendPresenter getsInstance() {
        if (sInstance == null) {
            synchronized (RecommendPresenter.class) {
                if (sInstance == null) {
                    sInstance = new RecommendPresenter();
                }
            }
        }
        return sInstance;
    }


    @Override
    public void getRecommendList() {
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
                        handleRecommendResult(albumList);
                    }
                }
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.d(TAG, "error --> " + s);

            }
        });
    }

    private void handleRecommendResult(List<Album> albumList) {
        // 通知UI
        if (mCallbacks != null) {
            for (IRecommendViewCallback cb: mCallbacks) {
                cb.onRecommendListLoad(albumList);
            }
        }
    }


    @Override
    public void pull2RefreshMore() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void registerViewCallback(IRecommendViewCallback callback) {
        if (mCallbacks != null && !mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }

    }

    @Override
    public void unRegisterViewCallback(IRecommendViewCallback callback) {
        if (mCallbacks != null) {
            mCallbacks.remove(callback);
        }
    }
}
