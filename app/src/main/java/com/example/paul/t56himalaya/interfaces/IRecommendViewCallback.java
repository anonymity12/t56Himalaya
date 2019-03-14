package com.example.paul.t56himalaya.interfaces;

import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.List;

/**
 * Created by paul on 2019/3/14
 * last modified at 13:45.
 * Desc:
 */

public interface IRecommendViewCallback {

    void onRecommendListLoad(List<Album> result);

    /*上滑*/
    void onLoadMore(List<Album> result);

    /*下滑*/
    void onRefreshMore(List<Album> result);
}
