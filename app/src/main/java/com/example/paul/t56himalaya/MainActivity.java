package com.example.paul.t56himalaya;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.paul.t56himalaya.adapters.IndicatorAdapter;
import com.example.paul.t56himalaya.adapters.MainContentAdapter;
import com.example.paul.t56himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private MagicIndicator mMagicIndicator;
    private ViewPager contentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mMagicIndicator = this.findViewById(R.id.main_indicator);
        mMagicIndicator.setBackgroundColor(getResources().getColor(R.color.main_color));
        // 创建适配器
        IndicatorAdapter adapter = new IndicatorAdapter(this);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(adapter);


        //s2 view pager
        contentPager = findViewById(R.id.content_pager);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(supportFragmentManager);
        contentPager.setAdapter(mainContentAdapter);

        // s3 bind viewpager and adapter
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator, contentPager);
    }
}
