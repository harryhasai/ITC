package com.hengkai.itc.function.my_sign_up.detail;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.forget_password.ForgetPasswordActivity;
import com.hengkai.itc.function.forget_password.fragment.StepOneFragment;
import com.hengkai.itc.function.forget_password.fragment.StepTwoFragment;
import com.hengkai.itc.network.entity.ForgetPasswordEntity;
import com.hengkai.itc.network.entity.ListOfPersonEntity;
import com.hengkai.itc.utils.OkHttpHelper;
import com.hengkai.itc.utils.SPUtils;
import com.jaeger.library.StatusBarUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Harry on 2018/9/7.
 * 活动报名的人员名单
 */
public class ListOfPersonActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private int activityID;

    @Override
    protected int setupView() {
        return R.layout.activity_list_of_person;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("人员名单");
        activityID = getIntent().getIntExtra("activityID", 0);

        initData();
    }

    private void initData() {
        Map<String, String> params = new HashMap<>();
        params.put("UserId", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("EventId", String.valueOf(activityID));
        params.put("Token", SPUtils.getString(UserInfo.TOKEN.name(), ""));
        OkHttpHelper.post(URLFinal.BASE_URL + URLFinal.LIST_OF_PERSON, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                if (!TextUtils.isEmpty(s)) {
                    Gson gson = new Gson();
                    ListOfPersonEntity listOfPersonEntity = gson.fromJson(s, ListOfPersonEntity.class);
                    switch (listOfPersonEntity.code) {
                        case 1:
                            setupList(listOfPersonEntity.applyName, listOfPersonEntity.applyPhone);
                            break;
                        case 0:
                            showLoginDialog(ListOfPersonActivity.this);
                            break;
                        default:
                            ToastUtils.showShort(listOfPersonEntity.msg);
                            break;
                    }
                }
            }
        });
    }

    private void setupList(String applyName, String applyPhone) {
        final List<String> nameList = new ArrayList<>(Arrays.asList(applyName.split(",")));
        final List<String> phoneList = new ArrayList<>(Arrays.asList(applyPhone.split(",")));

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setLayoutManager(new LinearLayoutManager(ListOfPersonActivity.this));
                recyclerView.setAdapter(new ListOfPersonAdapter(nameList, phoneList, ListOfPersonActivity.this, activityID));
                recyclerView.addItemDecoration(new DividerItemDecoration(ListOfPersonActivity.this, DividerItemDecoration.VERTICAL));
            }
        });
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
