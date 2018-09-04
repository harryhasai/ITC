package com.hengkai.itc.function.activity_list_detail.sign_up;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.utils.QRCodeUtil;
import com.hengkai.itc.utils.SPUtils;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/31.
 * 资讯 - 活动列表详情 - 活动报名
 */
public class SignUpActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_image)
    ImageView ivImage;

    @Override
    protected int setupView() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        int activityID = getIntent().getIntExtra("activityID", 0);
        String userID = SPUtils.getString(UserInfo.USER_ID.name(), "");

        tvTitle.setText("活动报名");
        ivImage.setImageBitmap(QRCodeUtil.createQRCodeBitmap("http://192.168.2.102:8080/ITCAPP/activity/tohdbm?UserId=" + userID + "&EventId=" + activityID, 480, 480));
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
