package com.hengkai.itc.function.my_fund_apply_record;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.custom_view.refreshing.LoadMoreFooterView;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.function.news_detail.NewsDetailActivity;
import com.hengkai.itc.function.news_list.NewsListActivity;
import com.hengkai.itc.function.news_list.NewsListAdapter;
import com.hengkai.itc.network.entity.FundApplyRecordEntity;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harry on 2018/8/27.
 * 我的基金申请记录
 */
public class FundApplyRecordActivity extends BaseActivity<FundApplyRecordPresenter> {

    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    LoadMoreFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<FundApplyRecordEntity.DataBean> mList;
    private boolean isLoadMore = false;
    private int pageNum = 1;
    private FundApplyRecordAdapter adapter;

    @Override
    protected int setupView() {
        return R.layout.activity_fund_apply_record;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        mList = new ArrayList<>();

        initTitle();
        initRecyclerView();

        mPresenter.getApplyList(pageNum);
    }

    @Override
    protected FundApplyRecordPresenter bindPresenter() {
        return new FundApplyRecordPresenter();
    }

    private void initTitle() {
        ImageView ivBack = findViewById(R.id.iv_back);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("基金申请记录");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FundApplyRecordAdapter(R.layout.item_fund_apply_record, mList);
        swipeTarget.setAdapter(adapter);
        swipeTarget.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                pageNum = 1;
                mPresenter.getApplyList(pageNum);
                isLoadMore = false;
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                mPresenter.getApplyList(pageNum);
                isLoadMore = true;
            }
        });

    }

    public void getApplyList(List<FundApplyRecordEntity.DataBean> data) {
        if (!isLoadMore) {//如果不是上拉加载更多, 则清空集合重新加载新数据
            mList.clear();
        }
        mList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    public void stopRefreshing() {
        swipeToLoadLayout.setRefreshing(false);
        swipeToLoadLayout.setLoadingMore(false);
    }
}
