package com.baidu.weiying.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.base.BaseActivity;
import com.baidu.weiying.view.fragments.ChoicenessFragment;
import com.baidu.weiying.view.fragments.DiscoverFragment;
import com.baidu.weiying.view.fragments.DissertationFragment;
import com.baidu.weiying.view.fragments.MyFragment;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
/**
 * 主页
 * */
public class MainActivity extends BaseActivity {

    private TextView mMainTitle;
    private ImageView mMainImageUser;
    private ViewPager mMainViewPager;
    private RadioGroup mMainRadioGroup;
    /**
     * 精选
     */
    private RadioButton mBtn01;
    /**
     * 专题
     */
    private RadioButton mBtn02;
    /**
     * 发现
     */
    private RadioButton mBtn03;
    /**
     * 我的
     */
    private RadioButton mBtn04;
    private List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Object getPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        mMainTitle = (TextView) findViewById(R.id.main_title);
        mMainImageUser = (ImageView) findViewById(R.id.main_image_user);
        mMainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mMainRadioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
        mBtn01 = (RadioButton) findViewById(R.id.btn_01);
        mBtn02 = (RadioButton) findViewById(R.id.btn_02);
        mBtn03 = (RadioButton) findViewById(R.id.btn_03);
        mBtn04 = (RadioButton) findViewById(R.id.btn_04);
        list = new ArrayList<>();
        //设置viewpager不能左右滑动
        mMainViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    protected void getData() {
        //设置头像为圆形
        Glide.with(this)
                .load(R.mipmap.photo)
                .into(mMainImageUser);
        //像集合中添加数据
        list.add(new ChoicenessFragment());
        list.add(new DissertationFragment());
        list.add(new DiscoverFragment());
        list.add(new MyFragment());
        //设置适配器
        mMainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list != null ? list.size() : 0;
            }
        });
        //RadioGroup选中监听
        mMainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_01:
                        //设置标题
                        mMainTitle.setText(mBtn01.getText().toString().trim());
                        mMainViewPager.setCurrentItem(0);
                        break;
                    case R.id.btn_02:
                        //设置标题
                        mMainTitle.setText(mBtn02.getText().toString().trim());
                        mMainViewPager.setCurrentItem(1);
                        break;
                    case R.id.btn_03:
                        mMainTitle.setText(mBtn03.getText().toString().trim());
                        mMainViewPager.setCurrentItem(2);
                        break;
                    case R.id.btn_04:
                        //设置标题
                        mMainTitle.setText(mBtn04.getText().toString().trim());
                        mMainViewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });

    }


}
