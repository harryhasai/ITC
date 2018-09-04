package com.hengkai.itc.function.forget_password.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.forget_password.ForgetPasswordActivity;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.ForgetPasswordEntity;
import com.hengkai.itc.utils.DeviceUtill;
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
 * 忘记密码 - 第一步
 */
public class StepOneFragment extends BaseFragment {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_verification_code)
    Button btnVerificationCode;
    @BindView(R.id.et_verification_code)
    EditText etVerificationCode;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;
    private CountDownTimer countDownTimer;

    @Override
    protected int setupView() {
        return R.layout.fragment_step_one;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

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

    @OnClick({R.id.btn_verification_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_verification_code:
                verificationCode();
                break;
            case R.id.btn_next:
                next();
                break;
        }
    }

    private void next() {
        final String phone = etPhone.getText().toString().trim();
        String verificationCode = etVerificationCode.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShort("电话号码不能为空");
            return;
        }
        if (TextUtils.isEmpty(verificationCode)) {
            ToastUtils.showShort("验证码不能为空");
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("Phone", phone);
        params.put("securityCode", verificationCode);

        OkHttpHelper.post(URLFinal.BASE_URL + URLFinal.VERIFY_VERIFICATION_CODE, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                if (!TextUtils.isEmpty(s)) {
                    Gson gson = new Gson();
                    ForgetPasswordEntity forgetPasswordEntity = gson.fromJson(s, ForgetPasswordEntity.class);
                    switch (forgetPasswordEntity.code) {
                        case 1:
                            ForgetPasswordActivity activity = (ForgetPasswordActivity) mActivity;
                            StepTwoFragment targetFragment = new StepTwoFragment();
                            Bundle args = new Bundle();
                            args.putString("securityNumber", forgetPasswordEntity.securityNumber);
                            args.putString("phone", phone);
                            targetFragment.setArguments(args);
                            activity.switchFragment(StepOneFragment.this, targetFragment);
                            countDownTimer.cancel();
                            break;
                        default:
                            ToastUtils.showShort(forgetPasswordEntity.msg);
                            break;
                    }
                }
            }
        });

    }

    /**
     * 获取验证码
     */
    private void verificationCode() {
        btnVerificationCode.setClickable(false);
        etVerificationCode.setText("");
        String phone = etPhone.getText().toString().trim();
        String telRegex = "^1[0-9]{10}$";
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShort("请先输入电话号码");
            btnVerificationCode.setClickable(true);
            return;
        }
        if (!phone.matches(telRegex)) {
            ToastUtils.showShort("请输入正确的电话号码");
            btnVerificationCode.setClickable(true);
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("Phone", phone);
        params.put("UUID", DeviceUtill.getDeviceUUID());
        OkHttpHelper.post(URLFinal.BASE_URL + URLFinal.SEND_VERIFICATION_CODE, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showShort("网络连接错误");
                btnVerificationCode.setClickable(true);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                if (!TextUtils.isEmpty(s)) {
                    Gson gson = new Gson();
                    CommonEntity commonEntity = gson.fromJson(s, CommonEntity.class);
                    switch (commonEntity.code) {
                        case 1:
                            mActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    countDown();
                                }
                            });
                            break;
                        default:
                            ToastUtils.showShort(commonEntity.msg);
                            btnVerificationCode.setClickable(true);
                            break;
                    }
                }
            }
        });
    }

    /**
     * 倒计时
     */
    private void countDown() {
        countDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnVerificationCode.setText("发送验证码(" + millisUntilFinished / 1000 + ")");
                btnVerificationCode.setClickable(false);
            }

            @Override
            public void onFinish() {
                btnVerificationCode.setText("发送验证码");
                btnVerificationCode.setClickable(true);
            }
        };
        countDownTimer.start();
    }

}
