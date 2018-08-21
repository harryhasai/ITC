package com.hengkai.itc.function.home;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.HomeMultiItem;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/15.
 * 首页适配器
 */
public class HomeAdapter extends BaseMultiItemQuickAdapter<HomeMultiItem, BaseViewHolder> {

    private List<Integer> images;
    private Activity mActivity;
    private List<HomeNewsListEntity.DataBean> newsListData;
    private HomeNewsListAdapter newsListAdapter;
    private String attachmentPath;
    private HomePresenter mPresenter;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *  @param data A new list is created out of this one to avoid mutable list
     * @param newsListData
     * @param attachmentPath
     */
    public HomeAdapter(List<HomeMultiItem> data, Activity activity,
                       List<HomeNewsListEntity.DataBean> newsListData, String attachmentPath,
                       HomePresenter mPresenter) {
        super(data);
        mActivity = activity;
//        addItemType(HomeMultiItem.TITLE, R.layout.view_home_title);
        addItemType(HomeMultiItem.BANNER, R.layout.view_home_banner);
        addItemType(HomeMultiItem.MENU, R.layout.view_home_menu);
        addItemType(HomeMultiItem.SHORTCUT, R.layout.view_home_shortcut);
        addItemType(HomeMultiItem.MORE, R.layout.view_home_more);
        addItemType(HomeMultiItem.NEWS_LIST, R.layout.view_home_news_list);

        initImages();

        this.mPresenter = mPresenter;
        this.newsListData = newsListData;
        this.attachmentPath = attachmentPath;
    }

    private void initImages() {
        images = new ArrayList<>();
        images.add(R.drawable.banner1);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
        images.add(R.drawable.banner4);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeMultiItem item) {
        switch (helper.getItemViewType()) {
//            case HomeMultiItem.TITLE:
//                break;
            case HomeMultiItem.BANNER:
                setupBanner(helper);
                break;
            case HomeMultiItem.MENU:
                //绑定子控件的点击事件
                helper.addOnClickListener(R.id.ll_about);
                helper.addOnClickListener(R.id.ll_need_know);
                helper.addOnClickListener(R.id.ll_question);
                helper.addOnClickListener(R.id.ll_apply);
                break;
            case HomeMultiItem.SHORTCUT:
                //绑定子控件的点击事件
                helper.addOnClickListener(R.id.ll_accelerator);
                helper.addOnClickListener(R.id.ll_incubator);
                helper.addOnClickListener(R.id.ll_service_platform);
                helper.addOnClickListener(R.id.ll_space);
                break;
            case HomeMultiItem.MORE:
                helper.addOnClickListener(R.id.rl_look_at_more);
                break;
            case HomeMultiItem.NEWS_LIST:
                setupRecyclerView(helper);
                break;
            default:
                break;
        }
    }

    /**
     * 配置新闻列表页面
     *
     * @param helper BaseViewHolder
     */
    private void setupRecyclerView(BaseViewHolder helper) {
        RecyclerView recyclerView = helper.getView(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(layoutManager);
        newsListAdapter = new HomeNewsListAdapter(R.layout.item_home_news_list, newsListData, mActivity, attachmentPath);
        recyclerView.setAdapter(newsListAdapter);

        newsListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort("点击了第" + position + "条数据查看详情");
                HomeNewsListEntity.DataBean bean = newsListData.get(position);
                if (bean.isImgNews) {
                    //图片新闻

                } else {
                    //文字新闻
                }
            }
        });

        mPresenter.getNewsList();

    }

    /**
     * 配置轮播图
     *
     * @param helper BaseViewHolder
     */
    private void setupBanner(BaseViewHolder helper) {
        Banner banner = helper.getView(R.id.banner);
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

    public void refreshNewsListAdapter() {
        newsListAdapter.notifyDataSetChanged();
    }
}
