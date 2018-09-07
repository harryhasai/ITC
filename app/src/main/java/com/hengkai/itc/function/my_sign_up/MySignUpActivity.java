package com.hengkai.itc.function.my_sign_up;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.custom_view.refreshing.LoadMoreFooterView;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.function.my_sign_up.detail.MySignUpDetailActivity;
import com.hengkai.itc.network.entity.MySignUpEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/30.
 * 我的活动报名
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

    private List<MySignUpEntity.DataBean> mList;
    private boolean isLoadMore = false;
    private int pageNum = 1;
    private MySignUpAdapter adapter;

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
        mList = new ArrayList<>();
        initRecyclerView();

        mPresenter.getSignUpList(pageNum);
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

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MySignUpAdapter(R.layout.item_my_sign_up, mList);
        swipeTarget.setAdapter(adapter);

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                pageNum = 1;
                mPresenter.getSignUpList(pageNum);
                isLoadMore = false;
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                mPresenter.getSignUpList(pageNum);
                isLoadMore = true;
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MySignUpActivity.this, MySignUpDetailActivity.class);
                intent.putExtra("activityID", mList.get(position).id);
                intent.putExtra("isImgActivity", mList.get(position).isImgActivity);
                startActivity(intent);
            }
        });


    }

    public void getSignUpList(List<MySignUpEntity.DataBean> data) {
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
