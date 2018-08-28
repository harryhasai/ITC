package com.hengkai.itc.function.my_fund;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.custom_view.refreshing.LoadMoreFooterView;
import com.hengkai.itc.custom_view.refreshing.RefreshHeaderView;
import com.hengkai.itc.function.my_fund.detail.MyFundDetailActivity;
import com.hengkai.itc.function.my_fund_apply_record.FundApplyRecordActivity;
import com.hengkai.itc.function.news_detail.NewsDetailActivity;
import com.hengkai.itc.function.news_list.NewsListActivity;
import com.hengkai.itc.function.news_list.NewsListAdapter;
import com.hengkai.itc.network.entity.HomeNewsListEntity;
import com.hengkai.itc.network.entity.MyFundEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Harry on 2018/8/27.
 *  我的基金
 */
public class MyFundActivity extends BaseActivity<MyFundPresenter> {

    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView swipeRefreshHeader;
    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipe_load_more_footer)
    LoadMoreFooterView swipeLoadMoreFooter;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private List<MyFundEntity.DataBean> mList;
    private boolean isLoadMore = false;
    private int pageNum = 1;
    private MyFundAdapter adapter;

    @Override
    protected int setupView() {
        return R.layout.activity_my_fund;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        mList = new ArrayList<>();

        initTitle();
        initRecyclerView();

        mPresenter.getFundList(null, pageNum);
    }

    @Override
    protected MyFundPresenter bindPresenter() {
        return new MyFundPresenter();
    }

    private void initTitle() {
        ImageView ivBack = findViewById(R.id.iv_back);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvRight = findViewById(R.id.tv_right);
        tvRight.setText("申请记录");
        tvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        tvTitle.setText("我的基金");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyFundActivity.this, FundApplyRecordActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyFundAdapter(R.layout.item_my_fund_list, mList, this);
        swipeTarget.setAdapter(adapter);

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                pageNum = 1;
                mPresenter.getFundList(null, pageNum);
                isLoadMore = false;
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                mPresenter.getFundList(null, pageNum);
                isLoadMore = true;
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MyFundEntity.DataBean bean = mList.get(position);
                Intent intent = new Intent(MyFundActivity.this, MyFundDetailActivity.class);
                intent.putExtra("ID", bean.id);
                startActivity(intent);
            }
        });


    }

    public void getFundList(List<MyFundEntity.DataBean> data, String attachmentPath) {
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
