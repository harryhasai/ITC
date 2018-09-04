package com.hengkai.itc.function.my_sign_up;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.custom_view.refreshing.LoadMoreFooterView;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/30.
 * 我的报名
 */
public class MySignUpActivity extends BaseActivity<MySignUpPresenter> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    LoadMoreFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    @Override
    protected int setupView() {
        return R.layout.activity_my_sign_up;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("我的报名");


    }

    @Override
    protected MySignUpPresenter bindPresenter() {
        return new MySignUpPresenter();
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
