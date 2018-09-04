package com.hengkai.itc.function.forget_password;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.forget_password.fragment.StepOneFragment;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/9/3.
 * 忘记密码页面
 */
public class ForgetPasswordActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    private FragmentTransaction transaction;

    @Override
    protected int setupView() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("忘记密码");

        initFragment();
    }

    private void initFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_container, new StepOneFragment());
        transaction.commit();
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    public void switchFragment(Fragment currentFragment, Fragment targetFragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction
                    .hide(currentFragment)
                    .add(R.id.fl_container, targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment)
                    .commit();
        }
    }
}
