package com.hengkai.itc.function.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.network.entity.HomeMultiItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Harry on 2018/8/14.
 * 首页
 */
public class HomeFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<HomeMultiItem> mList;
    private HomeAdapter adapter;

    @Override
    protected int setupView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

        initData();
        initRecyclerView();
    }

    private void initData() {
        mList = new ArrayList<>();
//        mList.add(new HomeMultiItem(HomeMultiItem.TITLE));
        mList.add(new HomeMultiItem(HomeMultiItem.BANNER));
        mList.add(new HomeMultiItem(HomeMultiItem.MENU));
        mList.add(new HomeMultiItem(HomeMultiItem.SHORTCUT));
        mList.add(new HomeMultiItem(HomeMultiItem.MORE));
        mList.add(new HomeMultiItem(HomeMultiItem.NEWS_LIST));
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new HomeAdapter(mList, mActivity);
        swipeTarget.setAdapter(adapter);

        //为适配器的子控件设置点击事件监听
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_about://关于园区
                        ToastUtils.showShort("关于园区");
                        break;
                    case R.id.ll_need_know://入驻及须知
                        ToastUtils.showShort("入驻及须知");
                        break;
                    case R.id.ll_question://入驻常见问题
                        ToastUtils.showShort("入驻常见问题");
                        break;
                    case R.id.ll_apply://入驻申请
                        ToastUtils.showShort("入驻申请");
                        break;
                    case R.id.ll_accelerator://企业加速器
                        ToastUtils.showShort("企业加速器");
                        break;
                    case R.id.ll_incubator://企业孵化器
                        ToastUtils.showShort("企业孵化器");
                        break;
                    case R.id.ll_service_platform://公共服务平台
                        ToastUtils.showShort("公共服务平台");
                        break;
                    case R.id.ll_space://众创空间
                        ToastUtils.showShort("众创空间");
                        break;
                    case R.id.rl_look_at_more://查看更多
                        ToastUtils.showShort("查看更多");
                        break;
                }
            }
        });
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeToLoadLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
