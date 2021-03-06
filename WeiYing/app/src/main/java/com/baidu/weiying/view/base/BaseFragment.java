package com.baidu.weiying.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment抽取基类
 */

public abstract class BaseFragment<T> extends Fragment {
    public T presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
        presenter = getPresenter();
        initView(view);
        getData();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract T getPresenter();

    protected abstract void initView(View view);

    protected abstract void getData();
}
