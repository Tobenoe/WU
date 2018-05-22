package com.baidu.weiying.view.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.utils.CardAdapter;
import com.baidu.weiying.view.utils.CardConfig;
import com.baidu.weiying.view.utils.CardItemTouchCallBack;
import com.baidu.weiying.view.utils.SwipeCardLayoutManager;
import com.baidu.weiying.view.utils.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现页面
 */

public class DiscoverFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    private List<User> mData;

    private CardAdapter mAdapter;

    private TextView tv_del_count;

    private TextView tv_love_count;

    private int loveCount;  //喜欢的数量

    private int delCount;   //删除的数量
    private View view;
    /**
     * 喜欢:0
     */
    private TextView mTvLoveCount;
    /**
     * 删除:0
     */
    private TextView mTvDelCount;

    @Override
    protected int getLayoutId() {
        return R.layout.discover_fragment;
    }

    @Override
    protected Object getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    }

    @Override
    protected void getData() {


        mData = initData();

        //初始化卡片的基本配置参数

        CardConfig.initConfig(getContext());

        mRecyclerView.setLayoutManager(new SwipeCardLayoutManager());

        mAdapter = new CardAdapter(getContext(), initData());

        mRecyclerView.setAdapter(mAdapter);


        //三步

        //1.创建ItemTuchCallBack

        CardItemTouchCallBack callBack = new CardItemTouchCallBack(mRecyclerView, mAdapter, mData);

        //2.创建ItemTouchHelper并把callBack传进去

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);

        //3.与RecyclerView关联起来

        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }


    private List<User> initData() {

        List<User> datas = new ArrayList<>();

        datas.add(new User(R.mipmap.ic_launcher, "名字1", "其他1"));

        datas.add(new User(R.mipmap.ic_launcher, "名字2", "其他2"));

        datas.add(new User(R.mipmap.ic_launcher, "名字3", "其他3"));

        datas.add(new User(R.mipmap.ic_launcher, "名字4", "其他4"));

        datas.add(new User(R.mipmap.ic_launcher, "名字5", "其他5"));

        datas.add(new User(R.mipmap.ic_launcher, "名字6", "其他6"));

        datas.add(new User(R.mipmap.ic_launcher, "名字7", "其他7"));

        datas.add(new User(R.mipmap.ic_launcher, "名字8", "其他8"));

        return datas;

    }


}
