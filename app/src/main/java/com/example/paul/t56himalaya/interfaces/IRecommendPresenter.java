package com.example.paul.t56himalaya.interfaces;

/**
 * Created by paul on 2019/3/14
 * last modified at 13:43.
 * Desc:
 */

public interface IRecommendPresenter {
    /**
    * 获取推荐内容
    * */

    void getRecommendList();

    /**
    * 下拉
    * */
    void pull2RefreshMore();

    /**
     * 上滑
     * */
    void loadMore();

    void registerViewCallback(IRecommendViewCallback callback);

    void unRegisterViewCallback(IRecommendViewCallback callback);
}
