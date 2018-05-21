package com.baidu.weiying.view.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.weiying.R;

/**
 * Activity抽取基类
 */

public abstract class BaseActivity<T> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题
        getSupportActionBar().hide();
        //判断当sdk是否大 于等于5.0时执行沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(getLayoutId());
        presenter = getPresenter();
        initView();
        getData();
    }

    protected abstract int getLayoutId();

    protected abstract T getPresenter();

    protected abstract void initView();

    protected abstract void getData();

}
