package com.baidu.weiying.view.fragments.Jfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.weiying.R;
import com.baidu.weiying.presenter.VideoPLPresenter;
import com.baidu.weiying.view.adapters.VideoPladapter;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.PL_bean;
import com.baidu.weiying.view.fragments.Iview.VideoPLVinterface;

import java.util.List;

/**
 * Created by work on 2018/5/22.
 */

public class CommentFragment extends BaseFragment<VideoPLPresenter> implements VideoPLVinterface {

    private VideoPladapter videoPladapter;
    private View view;
    private RecyclerView mPlRecylerView;

    @Override
    protected int getLayoutId() {
        return R.layout.comment_layout;
    }

    @Override
    protected VideoPLPresenter getPresenter() {
        return new VideoPLPresenter(this);
    }

    @Override
    protected void initView(View view) {

        mPlRecylerView = (RecyclerView) view.findViewById(R.id.pl_recylerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mPlRecylerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void getData() {
        videoPladapter = new VideoPladapter(getContext());
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        presenter.getPL(id);


    }


    @Override
    public void OnSuccess(Object o) {
        PL_bean pl_bean = (PL_bean) o;
        String msg = pl_bean.getMsg();
        Log.i("TAG", msg + "--------msg----------");
        PL_bean.RetBean ret = pl_bean.getRet();
        List<PL_bean.RetBean.ListBean> list = ret.getList();
        videoPladapter.setList(list);
        mPlRecylerView.setAdapter(videoPladapter);

    }

    @Override
    public void Faild(String msg){


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.OnDestry();
    }


}
