package com.baidu.weiying.view.fragments;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.FaxianP;
import com.baidu.weiying.view.activity.LbplayterActivity;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.fragments.Iview.FaxianView;
import com.baidu.weiying.view.utils.CardAdapter;
import com.baidu.weiying.view.utils.CardConfig;
import com.baidu.weiying.view.utils.CardItemTouchCallBack;
import com.baidu.weiying.view.utils.SwipeCardLayoutManager;

import java.util.List;

/**
 * 发现页面
 */

public class DiscoverFragment extends BaseFragment<FaxianP> implements FaxianView{

    private RecyclerView mRecyclerView;

;

    private CardAdapter mAdapter;

    private List<HomePageSuperClass.RetBean.ListBean> mData;

 
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
    protected FaxianP getPresenter() {
        return new FaxianP(this);
    }

    @Override
    protected void initView(View view) {


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

    }
    @Override
    protected void getData() {


        presenter.getDatas();






    }





    @Override
    public void Yes(Object o) {
        HomePageSuperClass o1 = (HomePageSuperClass) o;
        List<HomePageSuperClass.RetBean.ListBean> list = o1.getRet().getList();
        final List<HomePageSuperClass.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();

        //初始化卡片的基本配置参数

        CardConfig.initConfig(getContext());

        mRecyclerView.setLayoutManager(new SwipeCardLayoutManager());

        mAdapter = new CardAdapter(getContext(), childList);

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), LbplayterActivity.class);
                intent.putExtra("loadurl",childList.get(position).getLoadURL());
                intent.putExtra("intro",childList.get(position).getDescription());
                startActivity(intent);
            }
        });


        //三步

        //1.创建ItemTuchCallBack

        CardItemTouchCallBack callBack = new CardItemTouchCallBack(mRecyclerView, mAdapter, childList);

        //2.创建ItemTouchHelper并把callBack传进去

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);

        //3.与RecyclerView关联起来

        itemTouchHelper.attachToRecyclerView(mRecyclerView);


    }

    @Override
    public void No(String e) {

    }


}
