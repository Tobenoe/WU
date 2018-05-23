package com.baidu.weiying.view.activity;

import com.baidu.weiying.view.bean.HomePageSuperClass;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/5/21.
 */

public interface IChoicenessView {

  void onbannersuccess(HomePageSuperClass homePageSuperClass);
  void onbannerfailed(Exception e);

  //展示列表的方法
  void showListData(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list);
}
