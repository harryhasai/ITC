package com.hengkai.itc.function.home;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.function.news_detail.NewsDetailActivity;
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

    private Activity mActivity;
    private List<HomeNewsListEntity.DataBean> newsListData;
    public HomeNewsListAdapter newsListAdapter;
    private HomePresenter mPresenter;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *  @param data A new list is created out of this one to avoid mutable list
     * @param newsListData
     */
    public HomeAdapter(List<HomeMultiItem> data, Activity activity,
                       List<HomeNewsListEntity.DataBean> newsListData,
                       HomePresenter mPresenter) {
        super(data);
        mActivity = activity;
//        addItemType(HomeMultiItem.TITLE, R.layout.view_home_title);
//        addItemType(HomeMultiItem.BANNER, R.layout.view_home_banner);
        addItemType(HomeMultiItem.MENU, R.layout.view_home_menu);
        addItemType(HomeMultiItem.SHORTCUT, R.layout.view_home_shortcut);
        addItemType(HomeMultiItem.MORE, R.layout.view_home_more);
        addItemType(HomeMultiItem.NEWS_LIST, R.layout.view_home_news_list);

        this.mPresenter = mPresenter;
        this.newsListData = newsListData;
    }



    @Override
    protected void convert(BaseViewHolder helper, HomeMultiItem item) {
        switch (helper.getItemViewType()) {
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
        newsListAdapter = new HomeNewsListAdapter(R.layout.item_home_news_list, newsListData, mActivity);
        recyclerView.setAdapter(newsListAdapter);

        newsListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeNewsListEntity.DataBean bean = newsListData.get(position);
                Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                intent.putExtra("isImgNews", bean.isImgNews);
                intent.putExtra("isComment", bean.isComment);
                intent.putExtra("newsId", bean.id);
                mActivity.startActivity(intent);

            }
        });

        mPresenter.getNewsList();

    }

    public void refreshNewsListAdapter() {
        newsListAdapter.notifyDataSetChanged();
    }
}
