package com.hengkai.itc.function.modify_password;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.ConstantFinal;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.login.LoginActivity;
import com.hengkai.itc.utils.EditTextFilterUtil;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/18.
 * 修改密码
 */
public class ModifyPasswordActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_old)
    EditText etOld;
    @BindView(R.id.et_new)
    EditText etNew;
    @BindView(R.id.et_confirm_new)
    EditText etConfirmNew;

    @Override
    protected int setupView() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);
        tvTitle.setText("修改密码");

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                commit();
                break;
        }
    }

    private void commit() {
        //过滤空格
        etConfirmNew.setFilters(EditTextFilterUtil.addSpaceFiltering());
        etNew.setFilters(EditTextFilterUtil.addSpaceFiltering());
        etOld.setFilters(EditTextFilterUtil.addSpaceFiltering());

        String oldPassword = etOld.getText().toString().trim();
        String newPassword = etNew.getText().toString().trim();
        String confirmNewPassword = etConfirmNew.getText().toString().trim();

        if (TextUtils.isEmpty(oldPassword)) {
            ToastUtils.showShort("旧密码不能为空");
            return;
        } else if (TextUtils.isEmpty(newPassword)) {
            ToastUtils.showShort("新密码不能为空");
            return;
        } else if (TextUtils.isEmpty(confirmNewPassword)) {
            ToastUtils.showShort("确认新密码不能为空");
            return;
        }

        if (!newPassword.matches("^[0-9A-Za-z]{6,20}$") || !newPassword.matches("^[0-9A-Za-z]{6,20}$")) {
            ToastUtils.showShort("请输入正确的6~20位的数字或者字母");
            return;
        }

        if (!newPassword.equals(confirmNewPassword)) {
            ToastUtils.showShort("两次新密码不一致, 请重新输入");
            return;
        }

    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("修改密码成功")
                .setMessage("为了您的账户安全, 请牢记登录密码并妥善保管")
                .setPositiveButton("马上登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ModifyPasswordActivity.this, LoginActivity.class));
                        // TODO: 2018/8/18 修改用户是否登录的信息
                        dialog.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("返回首页", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        setResult(ConstantFinal.MODIFY_PASSWORD_RESULT_CODE);
                        finish();
                    }
                }).show();
    }
}
