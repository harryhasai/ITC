package com.hengkai.itc.function.my_reply;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.my_comment.MyCommentAdapter;
import com.hengkai.itc.network.entity.MyReplyEntity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/18.
 * 回复我的
 */
public class MyReplyActivity extends BaseActivity {

    private List<MyReplyEntity> mList;

    @Override
    protected int setupView() {
        return R.layout.activity_my_reply;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);

        mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add(new MyReplyEntity());
        }

        initTitle();
        initRecyclerView();
    }

    private void initTitle() {
        ImageView ivBack = findViewById(R.id.iv_back);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("回复我的");
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyReplyAdapter(R.layout.item_my_reply, mList));
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }
}
