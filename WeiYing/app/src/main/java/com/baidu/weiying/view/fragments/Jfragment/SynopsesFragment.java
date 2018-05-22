package com.baidu.weiying.view.fragments.Jfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.adapters.VideoTjAdapter;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.VideoLBean;

import java.util.List;

/**
 * Created by work on 2018/5/22.
 */

public class SynopsesFragment extends BaseFragment implements View.OnClickListener {
    private boolean flag;
    private View view;
    /**
     * 导演
     */
    private TextView mVidepdaoyan;
    /**
     * 主演
     */
    private TextView mVidezhuyan;
    private RecyclerView mJianjieRecylerView;
    /**
     * 简介
     */
    private TextView mVideoJj;
    private VideoTjAdapter videoTjAdapter;
    /**
     * 展开
     */
    private TextView mShouqi;

    @Override
    protected int getLayoutId() {
        return R.layout.synopses_layout;
    }

    @Override
    protected Object getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {

        mVidepdaoyan = (TextView) view.findViewById(R.id.videpdaoyan);
        mVidezhuyan = (TextView) view.findViewById(R.id.videzhuyan);
        mJianjieRecylerView = (RecyclerView) view.findViewById(R.id.jianjie_recylerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        mJianjieRecylerView.setLayoutManager(layoutManager);
        mVideoJj = (TextView) view.findViewById(R.id.video_jj);
        mShouqi = (TextView) view.findViewById(R.id.shouqi);
        mShouqi.setOnClickListener(this);
    }

    @Override
    protected void getData() {
        videoTjAdapter = new VideoTjAdapter(getContext());
        Bundle bundle = getArguments();
        //数据
        VideoLBean.RetBean ret = (VideoLBean.RetBean) bundle.getSerializable("ret");
        //简介
        String intro = bundle.getString("intro");

        String director = ret.getDirector();
        String actors = ret.getActors();
        mVidepdaoyan.setText("导演：" + director);
        mVidezhuyan.setText("主演：" + actors);
        mVideoJj.setText(intro);
        List<VideoLBean.RetBean.ListBean> list = ret.getList();
        List<VideoLBean.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();
        videoTjAdapter.setChildList(childList);
        mJianjieRecylerView.setAdapter(videoTjAdapter);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.shouqi:

                mVideoJj.setSingleLine(true);
                mShouqi.setText("展开");
                 if(!flag){
                     mVideoJj.setSingleLine(false);
                     mShouqi.setText("收起");
                     flag = true;
                 }else{

                     mVideoJj.setSingleLine(true);
                     mShouqi.setText("展开");
                     flag = false;
                 }


                break;
        }
    }
}
