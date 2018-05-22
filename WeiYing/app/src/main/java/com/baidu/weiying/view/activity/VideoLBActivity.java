package com.baidu.weiying.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.DiscoverPresenter;
import com.baidu.weiying.view.adapters.VideoLbAdapter;
import com.baidu.weiying.view.base.BaseActivity;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.fragments.Iview.IDiscoverView;

import java.util.List;

public class VideoLBActivity extends BaseActivity<DiscoverPresenter> implements IDiscoverView {


    private String prostion;
    private VideoLbAdapter videoLbAdapter;
    private RecyclerView video_lb_recylerview;
    private List<HomePageSuperClass.RetBean.ListBean.ChildListBean> childList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_lb;
    }

    @Override
    protected DiscoverPresenter getPresenter() {
        return new DiscoverPresenter(this);
    }

    @Override
    protected void initView() {
        video_lb_recylerview = findViewById(R.id.video_lb_recylerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        video_lb_recylerview.setLayoutManager(layoutManager);
    }

    @Override
    protected void getData() {
        videoLbAdapter = new VideoLbAdapter(this);
        presenter.getData();
        Intent intent = getIntent();
        //传过来的id
        prostion = intent.getStringExtra("prostion");

        setListenter();
    }



    @Override
    public void OnSuccess(Object o) {

        HomePageSuperClass homePageSuperClass = (HomePageSuperClass) o;
        HomePageSuperClass.RetBean ret = homePageSuperClass.getRet();

        int i = Integer.parseInt(prostion);
        Log.i("TAG",i+"---------");
        childList = ret.getList().get(i).getChildList();
        videoLbAdapter.setChildList(childList);
        video_lb_recylerview.setAdapter(videoLbAdapter);



    }
    private void setListenter() {

        videoLbAdapter.setVideoLbListenter(new VideoLbAdapter.VideoLbListenter() {
            @Override
            public void Onclick(View view, int prostion) {


                String loadURL = childList.get(prostion).getLoadURL();
                String description = childList.get(prostion).getDescription();
                Intent intent = new Intent(VideoLBActivity.this, LbplayterActivity.class);
                intent.putExtra("loadurl",loadURL+"");
                intent.putExtra("intro",description+"");
                startActivity(intent);



            }
        });


    }
    @Override
    public void Faild(String msg) {

    }
}
