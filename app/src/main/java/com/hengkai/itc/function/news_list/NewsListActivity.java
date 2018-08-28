package com.hengkai.itc.function.news_list;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.custom_view.refreshing.LoadMoreFooterView;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.function.my_reply.MyReplyAdapter;
import com.hengkai.itc.function.news_detail.NewsDetailActivity;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harry on 2018/8/25.
 * 新闻列表页面
 */
public class NewsListActivity extends BaseActivity<NewsListPresenter> {

    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    LoadMoreFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<HomeNewsListEntity.DataBean> mList;
    private boolean isLoadMore = false;
    private int pageNum = 1;
    private int childID;
    private NewsListAdapter adapter;

    @Override
    protected int setupView() {
        return R.layout.activity_news_list;
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

        mPresenter.getNewsList(childID, pageNum);

    }

    @Override
    protected NewsListPresenter bindPresenter() {
        return new NewsListPresenter();
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
        adapter = new NewsListAdapter(R.layout.item_home_news_list, mList, this);
        swipeTarget.setAdapter(adapter);

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                pageNum = 1;
                mPresenter.getNewsList(childID, pageNum);
                isLoadMore = false;
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                mPresenter.getNewsList(childID, pageNum);
                isLoadMore = true;
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeNewsListEntity.DataBean bean = mList.get(position);
                Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
                intent.putExtra("isImgNews", bean.isImgNews);
                intent.putExtra("isComment", bean.isComment);
                intent.putExtra("newsId", bean.id);
                startActivity(intent);
            }
        });


    }

    public void getNewsList(List<HomeNewsListEntity.DataBean> data, String attachmentPath) {
        if (!isLoadMore) {//如果不是上拉加载更多, 则清空集合重新加载新数据
            mList.clear();
        }
        mList.addAll(data);
        adapter.attachmentPath = attachmentPath;
        adapter.notifyDataSetChanged();
    }

    public void stopRefreshing() {
        swipeToLoadLayout.setRefreshing(false);
        swipeToLoadLayout.setLoadingMore(false);
    }
}
