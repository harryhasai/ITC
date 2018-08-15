package com.hengkai.itc.function.informations;

import android.view.View;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;

/**
 * Created by Harry on 2018/8/14.
 * 资讯页面
 */
public class InformationFragment extends BaseFragment {

    @Override
    protected int setupView() {
        return R.layout.fragment_informations;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }
}
