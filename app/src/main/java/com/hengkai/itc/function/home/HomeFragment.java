package com.hengkai.itc.function.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.function.about_park.AboutParkActivity;
import com.hengkai.itc.function.common_question.CommonQuestionActivity;
import com.hengkai.itc.function.login.LoginActivity;
import com.hengkai.itc.function.need_know.NeedKnowActivity;
import com.hengkai.itc.network.entity.HomeMultiItem;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Harry on 2018/8/14.
 * 首页
 */
public class HomeFragment extends BaseFragment<HomePresenter> {

    Unbinder unbinder;
    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<HomeMultiItem> mList;
    private HomeAdapter adapter;
    private List<HomeNewsListEntity.DataBean> newsListData;
    /**
     * 新闻图片的前半部分
     */
    private String attachmentPath = "";

    @Override
    protected int setupView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        initTitleBar(view);
        unbinder = ButterKnife.bind(this, view);

        initData();
        initRecyclerView();

    }

    /**
     * 初始化标题栏, 因为在MainActivity上设置了沉浸式, 这里提高标题栏的高度
     */
    private void initTitleBar(View view) {
        TextView tvHomeTitleBar = view.findViewById(R.id.tv_home_title_bar);
        int statusBarHeight = ScreenUtils.getStatusBarHeight(mActivity);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tvHomeTitleBar.getLayoutParams();
        params.height += statusBarHeight;
        tvHomeTitleBar.setLayoutParams(params);
    }

    private void initData() {
        mList = new ArrayList<>();
        newsListData = new ArrayList<>();
//        mList.add(new HomeMultiItem(HomeMultiItem.TITLE));
        mList.add(new HomeMultiItem(HomeMultiItem.BANNER));
        mList.add(new HomeMultiItem(HomeMultiItem.MENU));
        mList.add(new HomeMultiItem(HomeMultiItem.SHORTCUT));
        mList.add(new HomeMultiItem(HomeMultiItem.MORE));
        mList.add(new HomeMultiItem(HomeMultiItem.NEWS_LIST));
    }

    @Override
    protected HomePresenter bindPresenter() {
        return new HomePresenter();
    }

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new HomeAdapter(mList, mActivity, newsListData, attachmentPath, mPresenter);
        swipeTarget.setAdapter(adapter);

        //为适配器的子控件设置点击事件监听
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_about://关于园区
                        startActivity(new Intent(mActivity, AboutParkActivity.class));
                        break;
                    case R.id.ll_need_know://入驻及须知
                        startActivity(new Intent(mActivity, NeedKnowActivity.class));
                        break;
                    case R.id.ll_question://入驻常见问题
                        startActivity(new Intent(mActivity, CommonQuestionActivity.class));
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
                mPresenter.getNewsList();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getNewsList(List<HomeNewsListEntity.DataBean> data, String attachmentPath) {
        this.attachmentPath = attachmentPath;
        newsListData.clear();
        newsListData.addAll(data);
        adapter.refreshNewsListAdapter();//更新新闻列表的数据
    }

    /**
     * 停止刷新
     */
    public void stopRefreshing() {
        swipeToLoadLayout.setRefreshing(false);
        swipeToLoadLayout.setLoadingMore(false);
    }
}
