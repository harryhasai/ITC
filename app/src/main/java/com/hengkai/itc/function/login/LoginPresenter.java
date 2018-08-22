package com.hengkai.itc.function.login;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.event_bus.LoginEvent;
import com.hengkai.itc.network.entity.LoginEntity;
import com.hengkai.itc.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Harry on 2018/8/20.
 */
public class LoginPresenter extends BasePresenter<LoginActivity> {

    private final LoginModel model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    public void login(String userName, String password) {
        model.login(userName, password, new Observer<LoginEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginEntity loginEntity) {
                switch (loginEntity.code) {
                    case 1:
                        saveInfo(loginEntity);
                        ToastUtils.showShort("登录成功");
                        EventBus.getDefault().post(new LoginEvent());
                        view.finish();
                        break;
                    default:
                        ToastUtils.showShort(loginEntity.msg);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onComplete() {
                view.dismissDialog();
            }
        });
    }

    /**
     * @param loginEntity 保存用户信息
     */
    private void saveInfo(LoginEntity loginEntity) {
        SPUtils.putBoolean(UserInfo.IS_LOGIN.name(), true);
        SPUtils.putString(UserInfo.USER_ID.name(), String.valueOf(loginEntity.data.user.id));
        SPUtils.putString(UserInfo.LOGIN_NAME.name(), loginEntity.data.user.loginName);
        SPUtils.putString(UserInfo.PHONE.name(), loginEntity.data.user.phone);
        SPUtils.putString(UserInfo.EMAIL.name(), loginEntity.data.user.email);
        SPUtils.putString(UserInfo.USER_NAME.name(), loginEntity.data.user.name);
        SPUtils.putString(UserInfo.USER_ICON.name(), loginEntity.attachmentPath + loginEntity.data.user.headPortraitLink);
        SPUtils.putString(UserInfo.USER_ICON_FIRST_HALF.name(), loginEntity.attachmentPath);
        SPUtils.putBoolean(UserInfo.IS_DATA_REPORT.name(), loginEntity.isDataReport);
        SPUtils.putString(UserInfo.TOKEN.name(), loginEntity.token);

    }
}
