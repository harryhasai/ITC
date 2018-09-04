package com.hengkai.itc.function.forget_password.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.utils.OkHttpHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Harry on 2018/9/4.
 * 忘记密码 - 第二步
 */
public class StepTwoFragment extends BaseFragment {

    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_repeat_password)
    EditText etRepeatPassword;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    Unbinder unbinder;
    private String securityNumber;
    private String phone;

    @Override
    protected int setupView() {
        return R.layout.fragment_step_two;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            securityNumber = bundle.getString("securityNumber");
            phone = bundle.getString("phone");
        }


    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_commit)
    public void onViewClicked() {
        String password = etPassword.getText().toString().trim();
        String repeatPassword = etRepeatPassword.getText().toString().trim();

        if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort("新密码不能为空");
            return;
        } else if (TextUtils.isEmpty(repeatPassword)) {
            ToastUtils.showShort("确认新密码不能为空");
            return;
        }

        if (!password.equals(repeatPassword)) {
            ToastUtils.showShort("两次密码不一致");
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("Phone", phone);
        params.put("securityNumber", securityNumber);
        params.put("newPassword", password);
        params.put("repetitionPassword", repeatPassword);

        OkHttpHelper.post(URLFinal.BASE_URL + URLFinal.MODIFY_PASSWORD_VERIFICATION_CODE, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                if (!TextUtils.isEmpty(s)) {
                    Gson gson = new Gson();
                    CommonEntity commonEntity = gson.fromJson(s, CommonEntity.class);
                    switch (commonEntity.code) {
                        case 1:
                            ToastUtils.showShort("设置成功");
                            mActivity.finish();
                            break;
                        default:
                            ToastUtils.showShort(commonEntity.msg);
                            break;
                    }
                }
            }
        });
    }
}
