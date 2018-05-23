package com.baidu.weiying.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baidu.weiying.R;
import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.presenter.ChoicenessPresenter;
import com.baidu.weiying.view.activity.IChoicenessView;
import com.baidu.weiying.view.activity.LbplayterActivity;
import com.baidu.weiying.view.adapters.HomePageAdapter;
import com.baidu.weiying.view.adapters.ShouyeAdapter;
import com.baidu.weiying.view.base.BaseFragment;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.myapp.MyApplication;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 精选页面
 */

public class ChoicenessFragment extends BaseFragment implements IChoicenessView{

    private Banner banner;
    private RecyclerView recyclerview;
    private ShouyeAdapter shouyeAdapter;
    private List<HomePageSuperClass.RetBean.ListBean.ChildListBean> childList;
    private RelativeLayout homeserach;
    private List<HomePageSuperClass.RetBean.ListBean> data;

    @Override
    protected int getLayoutId() {
        return R.layout.choiceness_fragment;
    }

    @Override
    protected Object getPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {

        //初始化控件
        banner = view.findViewById(R.id.banner);
        //图片加载器
        banner.setImageLoader(new MyApp());
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String loadURL = data.get(position).getChildList().get(0).getLoadURL();
                String description = data.get(position).getChildList().get(position).getDescription();
                Intent intent=new Intent(getActivity(),LbplayterActivity.class);
                intent.putExtra("loadurl",loadURL+"");
                intent.putExtra("intro",description+"");
                startActivity(intent);
            }
        });

        //初始化recyclerview
        recyclerview = view.findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected void getData() {
        //图片集合
        ChoicenessPresenter choicenessPresenter=new ChoicenessPresenter(this);
        choicenessPresenter.showBanner("http://api.svipmovie.com/front/homePageApi/homePage.do");

        choicenessPresenter.showToView(new TotalModle(choicenessPresenter),this);
    }


    @Override
    public void onbannersuccess(final HomePageSuperClass homePageSuperClass) {

        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                data = homePageSuperClass.getRet().getList();
                List<String> list=new ArrayList<>();
                for(int i = 0; i< data.size(); i++){
                    String pic = data.get(i).getChildList().get(0).getPic();
                    list.add(pic);
                }
                banner.setImages(list);
                //在方法全部调用结束的时候再调用开始
                banner.start();

            }
        });

    }

    @Override
    public void onbannerfailed(Exception e) {

    }

    private class MyApp extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide加载图片的方法
            Glide.with(context).load(path).into(imageView);
        }
    }

    //展示列表的方法
    @Override
    public void showListData(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list) {

        Log.d("TAG", "showListData: "+list);

        //设置适配器
        shouyeAdapter = new ShouyeAdapter(list,getActivity());
        recyclerview.setAdapter(shouyeAdapter);

    }

}
