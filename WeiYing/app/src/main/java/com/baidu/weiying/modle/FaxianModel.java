package com.baidu.weiying.modle;

import com.baidu.weiying.presenter.IFaxianP;
import com.baidu.weiying.view.api.Api;
import com.baidu.weiying.view.api.ApiService;
import com.baidu.weiying.view.bean.Faxianclass;
import com.baidu.weiying.view.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by zs on 2018/5/22.
 */

public class FaxianModel implements IFaxianModel {
    @Override
    public void getData(IFaxianP iFaxianP) {
        ApiService retrofit = RetrofitUtils.getInData().getRetrofit(Api.HOST_NAME, ApiService.class);
        Flowable<Faxianclass> flowable = retrofit.getMssgea();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<Faxianclass>() {
                    @Override
                    public void onNext(Faxianclass faxianclass) {


                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
