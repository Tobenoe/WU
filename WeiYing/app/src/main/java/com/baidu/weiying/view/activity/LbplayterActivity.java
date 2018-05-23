package com.baidu.weiying.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.GetLbVideoPresenter;
import com.baidu.weiying.view.base.BaseActivity;
import com.baidu.weiying.view.bean.VideoLBean;
import com.baidu.weiying.view.fragments.Iview.GetLbViewInterface;
import com.baidu.weiying.view.fragments.Jfragment.CommentFragment;
import com.baidu.weiying.view.fragments.Jfragment.SynopsesFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class LbplayterActivity extends BaseActivity<GetLbVideoPresenter> implements GetLbViewInterface {

    private String[] tabs = {"简介", "评论"};
    private JCVideoPlayerStandard mVideoplayer;
    private ViewPager mVideoViewpager;
    private List<Fragment> fragments = new ArrayList<>();
    private TabLayout mVideoTablelayout;
    private String intro;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lbplayter;
    }

    @Override
    protected GetLbVideoPresenter getPresenter() {
        return new GetLbVideoPresenter(this);
    }

    @Override
    protected void initView() {
        //播放器
        mVideoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        //导航
        mVideoTablelayout = (TabLayout) findViewById(R.id.video_tablelayout);
        //viewpager
        mVideoViewpager = (ViewPager) findViewById(R.id.video_viewpager);

    }

    @Override
    protected void getData() {

        Intent intent = getIntent();
        String loadurl = intent.getStringExtra("loadurl");
        intro = intent.getStringExtra("intro");

        presenter.getVideo(loadurl);


    }


    @Override
    public void OnSuccess(Object o) {

        VideoLBean videoLBean = (VideoLBean) o;
        String msg = videoLBean.getMsg();
        VideoLBean.RetBean ret = videoLBean.getRet();
        String hdurl = ret.getHDURL();
        String[] m3u8s = hdurl.split("m3u8");
        String s = m3u8s[0] + "mp4";

        mVideoplayer.setUp(s, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, ret.getTitle());
        //设置tabs
        setTabs();
        //存储数据
        SynopsesFragment synopsesFragment = new SynopsesFragment();
        Bundle bundle = new Bundle();
//        List<VideoLBean.RetBean.ListBean> list = ret.getList();

        //bundle.putString("intro", intro);
        bundle.putString("intro", "暂无简介");
        bundle.putSerializable("ret", ret);

        synopsesFragment.setArguments(bundle);

        fragments.add(synopsesFragment);
        CommentFragment commentFragment = new CommentFragment();
        String dataID = ret.getDataID();
        bundle.putString("id", dataID);
        commentFragment.setArguments(bundle);
        fragments.add(commentFragment);
        //设置viewpager
        setviewpager();

    }

    private void setTabs() {
        for (int i = 0; i < tabs.length; i++) {

            mVideoTablelayout.addTab(mVideoTablelayout.newTab().setText(tabs[i]));

        }

        //设置tab与viewpager联动
        mVideoTablelayout.setupWithViewPager(mVideoViewpager);


    }

    private void setviewpager() {

        mVideoViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments != null ? fragments.size() : 0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }

        });

    }


    @Override
    public void Faild(String msg) {

    }

    @Override
    public void onBackPressed() {
        if (mVideoplayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoplayer.releaseAllVideos();
    }
}
