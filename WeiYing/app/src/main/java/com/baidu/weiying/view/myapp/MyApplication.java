package com.baidu.weiying.view.myapp;

import android.app.Application;

import com.baidu.weiying.view.adaptive.DensityHelper;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 初始化MyApplication类
 */

public class MyApplication extends Application {

    public final static float DESIGN_WIDTH = 750; //绘制页面时参照的设计图宽度

    @Override
    public void onCreate() {
        super.onCreate();
        new DensityHelper(this, DESIGN_WIDTH).activate();  //DESIGN_WIDTH为设计图宽度，同样不要忘记清单文件配置Application，另 布局中使用pt

        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(build);
    }
}
