package com.baidu.weiying.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.DiscoverPresenter;
import com.baidu.weiying.view.activity.VideoLBActivity;
import com.baidu.weiying.view.adapters.HomePageAdapter;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.fragments.Iview.IDiscoverView;

import java.util.List;

/**
 * 专题页面
 */

public class DissertationFragment extends BaseFragment<DiscoverPresenter> implements IDiscoverView {

    private RecyclerView choiceness_recylerview;
    private HomePageAdapter homePageAdapter;
    private View view;
    private RecyclerView mChoicenessRecylerview;

    @Override
    protected int getLayoutId() {
        return R.layout.dissertation_fragment;
    }

    @Override
    protected DiscoverPresenter getPresenter() {

        return new DiscoverPresenter(this);
    }

    @Override
    protected void initView(View view) {
        choiceness_recylerview = view.findViewById(R.id.choiceness_recylerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        choiceness_recylerview.setLayoutManager(layoutManager);


        mChoicenessRecylerview = (RecyclerView) view.findViewById(R.id.choiceness_recylerview);

    }

    @Override
    protected void getData() {
        homePageAdapter = new HomePageAdapter(getContext());
        presenter.getData();
        setOnClick();
    }

    private void setOnClick() {

        homePageAdapter.setVideoChickLister(new HomePageAdapter.VideoChickLister() {
            @Override
            public void Click(View view, int prostion) {


               Log.i("TAG",prostion+"---------");
                Intent intent = new Intent(getContext(), VideoLBActivity.class);

                intent.putExtra("prostion", prostion+"");

                startActivity(intent);


            }
        });


    }


    @Override
    public void OnSuccess(Object o) {

        HomePageSuperClass homePageSuperClass = (HomePageSuperClass) o;
        String msg = homePageSuperClass.getMsg();
        Log.i("TAG", msg);

        HomePageSuperClass.RetBean ret = homePageSuperClass.getRet();
        List<HomePageSuperClass.RetBean.ListBean> list = ret.getList();
        homePageAdapter.setList(list);
        choiceness_recylerview.setAdapter(homePageAdapter);

    }

    @Override
    public void Faild(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.OnDestry();

    }


}
