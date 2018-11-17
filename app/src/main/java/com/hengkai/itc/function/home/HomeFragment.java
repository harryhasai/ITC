package com.hengkai.itc.function.home;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Harry on 2018/8/14.
 * 首页
 */
public class HomeFragment extends BaseFragment<HomePresenter> {

    Unbinder unbinder;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;

    private List<HomeMultiItem> mList;
    private HomeAdapter adapter;
    private List<HomeNewsListEntity.DataBean> newsListData;
    private List<Integer> images;


    @Override
    protected int setupView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        initTitleBar(view);
        unbinder = ButterKnife.bind(this, view);

        initImages();
        setupBanner(view);
        initData();
        initRecyclerView();

    }

    private void initImages() {
        images = new ArrayList<>();
        images.add(R.drawable.banner1);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
        images.add(R.drawable.banner4);
    }

    /**
     * 配置轮播图
     */
    private void setupBanner(View view) {
        Banner banner = view.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    /**
     * 初始化标题栏, 因为在MainActivity上设置了沉浸式, 这里提高标题栏的高度
     */
    private void initTitleBar(View view) {
        TextView tvHomeTitleBar = view.findViewById(R.id.tv_home_title_bar);
        int statusBarHeight = ScreenUtils.getStatusBarHeight(mActivity);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) tvHomeTitleBar.getLayoutParams();
        params.height += statusBarHeight;
        tvHomeTitleBar.setLayoutParams(params);
    }

    private void initData() {
        mList = new ArrayList<>();
        newsListData = new ArrayList<>();
//        mList.add(new HomeMultiItem(HomeMultiItem.TITLE));
//        mList.add(new HomeMultiItem(HomeMultiItem.BANNER));
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
        adapter = new HomeAdapter(mList, mActivity, newsListData, mPresenter);
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
                        apply();
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
    }

    // 入住申请
    private void apply(){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity) ;
        dialogBuilder.create() ;
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_pop_qurest, null);
        dialogBuilder.setView(view) ;
        final Dialog dialog = dialogBuilder.show() ;
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        TextView tv_name = view.findViewById(R.id.tv_name);
        tv_name.setText("王经理");
        TextView tv_phone = view.findViewById(R.id.tv_phone);
        tv_phone.setText("15968564856");
        TextView tv_address = view.findViewById(R.id.tv_address);
        tv_address.setText("洛阳市西宫区王城大道111号信息科技城379");
        TextView tv_email = view.findViewById(R.id.tv_email);
        tv_email.setText("236514682@qq.com");
        ImageView iv_close = view.findViewById(R.id.iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getNewsList(List<HomeNewsListEntity.DataBean> data, String attachmentPath) {
        adapter.newsListAdapter.attachmentPath = attachmentPath;
        newsListData.clear();
        newsListData.addAll(data);
        adapter.refreshNewsListAdapter();//更新新闻列表的数据
    }

}
