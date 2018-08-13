package com.hengkai.itc.base;

import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hengkai.itc.R;
import com.hengkai.itc.application.ITCApplication;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.base.view.BaseActivityImpl;

/**
 * Created by Harry on 2018/8/13.
 */
public abstract class BaseActivity<P extends BasePresenter> extends BaseActivityImpl<P> {

    private ITCApplication application;
    private AlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setupView());
        application = (ITCApplication) getApplication();
        application.addActivity(this);

        //只是手机竖屏显示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initView();
    }

    /**
     * @return 布局文件的ID
     */
    protected abstract int setupView();

    /**
     * 初始化布局(例如findViewById)
     */
    protected abstract void initView();

    private void initDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.LoadingDialog);
        dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setView(View.inflate(this, R.layout.dialog_base, null));
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        application.finishActivity(this);   //清除栈中的Activity
    }

//    public void showLoginDialog(final Context context) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                context.startActivity(new Intent(context, LoginActivity.class));
//                dialog.dismiss();
//                //看需求, 是否需要发送消息在重新登录后刷新当前列表的数据, 这里暂时先不添加了
//            }
//        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        }).setMessage("您目前尚未登录，是否前往登录界面").show();
//    }
}
