package com.hengkai.itc.function.login;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.utils.ScreenUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Harry on 2018/8/14.
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_PHONE_STATE = 100;

    @Override
    protected int setupView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.transparent), 0);
        ScreenUtils.fullScreen(this);//背景全屏


    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    private void goToLogin() {

    }

    public void easyPermission() {
        String[] permissionList = new String[]{Manifest.permission.READ_PHONE_STATE};
        if (Build.VERSION.SDK_INT >= 23) {
            if (EasyPermissions.hasPermissions(this, permissionList)) {
                goToLogin();
            } else {
                EasyPermissions.requestPermissions(this, "需要读取手机状态的权限, 如果拒绝可能造成无法正常登陆", REQUEST_PHONE_STATE, permissionList);
            }
        } else {
            goToLogin();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        //同意了授权
        goToLogin();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        //拒绝了授权
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            //拒绝授权后，从系统设置了授权后，返回APP进行相应的操作
            goToLogin();
        }
    }
}
