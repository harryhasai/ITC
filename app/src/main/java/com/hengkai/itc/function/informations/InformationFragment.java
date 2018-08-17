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
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry on 2018/8/14.
 * 资讯页面
 */
public class InformationFragment extends BaseFragment {

    private String[] names = {"园区", "企业", "高校", "机构", "活动"};

    @Override
    protected int setupView() {
        return R.layout.fragment_informations;
    }

    @Override
    protected void initView(View view) {
        initTitleBar(view);

        setupRecyclerView(view);
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

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapter(new InformationAdapter(R.layout.item_information, data, mActivity));
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }
}
