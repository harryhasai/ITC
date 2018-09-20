package com.hengkai.itc.function.informations;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonItem;
import com.hengkai.itc.network.entity.InformationContentEntity;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/14.
 * 资讯页面
 */
public class InformationFragment extends BaseFragment<InformationPresenter> {

    private String[] names = {"园区", "企业", "高校", "机构", "活动"};
    private List<InformationContentEntity.DataBean> mList;
    private InformationAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected int setupView() {
        return R.layout.fragment_informations;
    }

    @Override
    protected void initView(View view) {
        initTitleBar(view);

        mList = new ArrayList<>();
        setupRecyclerView(view);

        mPresenter.getInformationType();
    }

    /**
     * 初始化标题栏, 因为在MainActivity上设置了沉浸式, 这里提高标题栏的高度
     */
    private void initTitleBar(View view) {
        RelativeLayout rlHomeTitleBar = view.findViewById(R.id.rl_home_title_bar);
        int statusBarHeight = ScreenUtils.getStatusBarHeight(mActivity);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rlHomeTitleBar.getLayoutParams();
        params.height += statusBarHeight;
        rlHomeTitleBar.setLayoutParams(params);
    }

    private void setupRecyclerView(View view) {
        List<CommonItem> data = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            data.add(new CommonItem(names[i]));
        }

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new InformationAdapter(R.layout.item_information, data, mActivity, mList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected InformationPresenter bindPresenter() {
        return new InformationPresenter();
    }

    public void getInformationType(List<InformationContentEntity.DataBean> list) {
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setFocusable(false);
    }
}
