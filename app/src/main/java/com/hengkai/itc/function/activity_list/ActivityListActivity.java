package com.hengkai.itc.function.activity_list;

import android.content.Intent;
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
import com.hengkai.itc.function.activity_list_detail.ActivityListDetailActivity;
import com.hengkai.itc.function.news_detail.NewsDetailActivity;
import com.hengkai.itc.function.news_list.NewsListActivity;
import com.hengkai.itc.function.news_list.NewsListAdapter;
import com.hengkai.itc.network.entity.ActivityListEntity;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harry on 2018/8/30.
 * 资讯 - 活动分类 - 活动列表
 */
public class ActivityListActivity extends BaseActivity<ActivityListPresenter> {

    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    LoadMoreFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<ActivityListEntity.DataBean> mList;
    private boolean isLoadMore = false;
    private int pageNum = 1;
    private int childID;
    private ActivityListAdapter adapter;

    @Override
    protected int setupView() {
        return R.layout.activity_activity_list;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        childID = getIntent().getIntExtra("childID", 0);
        String title = getIntent().getStringExtra("name");

        mList = new ArrayList<>();

        initTitle(title);
        initRecyclerView();

        mPresenter.getActivityList(childID, pageNum);

    }

    @Override
    protected ActivityListPresenter bindPresenter() {
        return new ActivityListPresenter();
    }

    private void initTitle(String title) {
        ImageView ivBack = findViewById(R.id.iv_back);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(title);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ActivityListAdapter(R.layout.item_activity_list, mList);
        swipeTarget.setAdapter(adapter);

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                pageNum = 1;
                mPresenter.getActivityList(childID, pageNum);
                isLoadMore = false;
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                mPresenter.getActivityList(childID, pageNum);
                isLoadMore = true;
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ActivityListActivity.this, ActivityListDetailActivity.class);
                intent.putExtra("activityID", mList.get(position).id);
                intent.putExtra("isImgActivity", mList.get(position).isImgActivity);
                startActivity(intent);
            }
        });


    }

    public void getActivityList(List<ActivityListEntity.DataBean> data, String attachmentPath) {
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
