package com.hengkai.itc.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hengkai.itc.R;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.base.view.BaseFragmentImpl;
import com.hengkai.itc.function.login.LoginActivity;
import com.hengkai.itc.utils.SPUtils;

/**
 * Created by Harry on 2018/8/13.
 */
public abstract class BaseFragment<P extends BasePresenter> extends BaseFragmentImpl<P> {

    protected Activity mActivity;
    private View view;
    private AlertDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        if (view == null) {
            view = inflater.inflate(setupView(), container, false);
            initView(view);
        }

        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            //如果存在,那么我就干掉,重写添加,这样的方式我们就可以缓存视图
            parent.removeView(view);
        }

        return view;
    }

    /**
     * @return 布局文件的ID
     */
    protected abstract int setupView();

    /**
     * 初始化布局(例如findViewById)
     *
     * @param view
     */
    protected abstract void initView(View view);

    private void initDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity, R.style.LoadingDialog);
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setView(View.inflate(mActivity, R.layout.dialog_base, null));
    }

    /**
     * 显示LoadingDialog
     */
    public void showDialog() {
        initDialog();
        dialog.show();
    }

    /**
     * 关闭LoadingDialog
     */
    public void dismissDialog() {
        if (dialog != null) {
            dialog.cancel();
        }
    }

    public void showLoginDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.startActivity(new Intent(context, LoginActivity.class));
                dialog.dismiss();
                SPUtils.putBoolean(UserInfo.IS_LOGIN.name(), false);
                SPUtils.putBoolean(UserInfo.IS_DATA_REPORT.name(), false);
                //看需求, 是否需要发送消息在重新登录后刷新当前列表的数据, 这里暂时先不添加了
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setMessage("您目前尚未登录，是否前往登录界面").show();
    }
}
