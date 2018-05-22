package com.baidu.weiying.presenter;

import com.baidu.weiying.modle.FaxianModel;
import com.baidu.weiying.view.fragments.Iview.FaxianView;

/**
 * Created by zs on 2018/5/22.
 */

public class FaxianP implements IFaxianP {
    private FaxianView faxianView;
    private FaxianModel faxianModel;
    public FaxianP(FaxianView faxianView) {
        this.faxianView = faxianView;
        faxianModel=new FaxianModel();
    }

    @Override
    public void Yes(Object o) {
        if (faxianView==null){
            return;
        }
        faxianView.Yes(o);

    }

    @Override
    public void No(String e) {
        if (faxianView==null){
            return;
        }
        faxianView.No(e);
    }

    @Override
    public void getDatas() {
        faxianModel.getData(this);

    }
}
