package com.baidu.weiying.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 启动页
 */
public class WelcomeActivity extends BaseActivity {

    private ImageView mIvWelcomeBg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected Object getPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        mIvWelcomeBg = (ImageView) findViewById(R.id.iv_welcome_bg);
    }

    @Override
    protected void getData() {
        //创建timer对象，实现3秒跳转
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
