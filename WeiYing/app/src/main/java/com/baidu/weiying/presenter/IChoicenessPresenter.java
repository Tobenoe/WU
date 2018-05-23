package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.TotalModle;
import com.baidu.weiying.view.activity.IChoicenessView;
import com.baidu.weiying.view.bean.HomePageSuperClass;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/5/21.
 */

public interface IChoicenessPresenter {

    //获取数据的方法
    void showBanner(String url);

    //关联M、V
    void showToView(TotalModle totalModle, IChoicenessView iChoicenessView);
    //获取列表的方法
    void getDataLists(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list);

}
