package com.baidu.weiying.view.fragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.DiscoverPresenter;
import com.baidu.weiying.view.adapters.HomePageAdapter;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.fragments.Iview.IDiscoverView;

import java.util.List;

/**
 * 精选页面
 */

public class ChoicenessFragment extends BaseFragment<DiscoverPresenter> implements IDiscoverView {

    private RecyclerView choiceness_recylerview;
    private HomePageAdapter homePageAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.choiceness_fragment;
    }

    @Override
    protected DiscoverPresenter getPresenter() {

        return new DiscoverPresenter(this);
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void getData() {



        presenter.getData();


    }

    @Override
    public void OnSuccess(Object o) {



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
