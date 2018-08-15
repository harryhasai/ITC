package com.hengkai.itc.function.informations;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonItem;

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
        setupRecyclerView(view);
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
