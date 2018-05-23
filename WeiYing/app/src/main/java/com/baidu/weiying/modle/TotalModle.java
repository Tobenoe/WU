package com.baidu.weiying.modle;

import android.os.Handler;
import android.util.Log;

import com.baidu.weiying.presenter.GetLbVideointerface;
import com.baidu.weiying.presenter.IDiscoverPresenter;
import com.baidu.weiying.presenter.VideoPLPinterface;
import com.baidu.weiying.view.api.Api;
import com.baidu.weiying.view.api.ApiService;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.baidu.weiying.view.bean.PL_bean;
import com.baidu.weiying.view.bean.VideoLBean;
import com.baidu.weiying.view.utils.RetrofitUtils;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Modle类
 */

public class TotalModle implements ITotalModle {
    //获取数据
    @Override
    public void getData(final IDiscoverPresenter discoverPresenter) {
        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.HOST_NAME, ApiService.class);
        //  Log.i("TAG","------------------------");
        Flowable<HomePageSuperClass> flowable = apiService.getData();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<HomePageSuperClass>() {
                    @Override
                    public void onNext(HomePageSuperClass homePageSuperClass) {
                        // Log.i("TAG","------------------------");
                        discoverPresenter.OnSuccess(homePageSuperClass);

                    }

                    @Override
                    public void onError(Throwable t) {

                        discoverPresenter.Faild(t.getMessage());
                        Log.i("TAG", "-----------------" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    // 获取列表详情视频
 private Handler handler = new Handler();
    @Override
    public void getVideo(String url, final GetLbVideointerface getLbVideointerface) {

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().get().url(url).build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getLbVideointerface.Faild(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();
                Log.i("TAG","------>"+string+"<------");
                Gson gson = new Gson();
                final VideoLBean videoLBean = gson.fromJson(string, VideoLBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getLbVideointerface.OnSuccess(videoLBean);
                    }
                });


            }
        });
    }
     //获取评论内容
    @Override
    public void getPl(String id, final VideoPLPinterface videoPLPinterface) {


        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Pl_URL, ApiService.class);
        Flowable<PL_bean> flowable = apiService.getPL(id);
        flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DefaultSubscriber<PL_bean>() {
            @Override
            public void onNext(PL_bean pl_bean) {

                videoPLPinterface.OnSuccess(pl_bean);

            }

            @Override
            public void onError(Throwable t) {

                videoPLPinterface.Faild(t.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });


    }

}
