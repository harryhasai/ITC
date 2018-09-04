package com.hengkai.itc;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.app_final.ConstantFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.home.HomeFragment;
import com.hengkai.itc.function.informations.InformationFragment;
import com.hengkai.itc.function.mine.MineFragment;
import com.hengkai.itc.utils.SPUtils;
import com.hengkai.itc.utils.ScreenUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private HomeFragment homeFragment;
    private InformationFragment informationFragment;
    private MineFragment mineFragment;

    @Override
    protected int setupView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ScreenUtils.fullScreen(this);
        ButterKnife.bind(this);

        setupBottomNavigationBar();

        bottomNavigationBar.selectTab(0);
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 初始化底部导航栏
     */
    private void setupBottomNavigationBar() {

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        //角标的数字
//        BadgeItem numberBadgeItem = new BadgeItem()
//                .setBorderWidth(0)
//                .setBackgroundColorResource(R.color.colorAccent)
//                .setText("5")
//                .setHideOnSelect(false);

//        numberBadgeItem.toggle(false); //开启或者关闭角标数字提示, 不传参数也可以

//        ShapeBadgeItem shapeBadgeItem = new ShapeBadgeItem()

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_navigation1, "首页").setInActiveColor(R.color.black1).setActiveColorResource(R.color.title_bar_bg))
                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_navigation2, "资讯").setInActiveColor(R.color.black1).setActiveColorResource(R.color.title_bar_bg))
                .addItem(new BottomNavigationItem(R.drawable.ic_bottom_navigation3, "我的").setInActiveColor(R.color.black1).setActiveColorResource(R.color.title_bar_bg))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                if (homeFragment != null) ft.hide(homeFragment);
                if (informationFragment != null) ft.hide(informationFragment);
                if (mineFragment != null) ft.hide(mineFragment);

                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            ft.add(R.id.fl_container, homeFragment);
                        } else {
                            ft.show(homeFragment);
                        }
                        break;
                    case 1:
                        if (informationFragment == null) {
                            informationFragment = new InformationFragment();
                            ft.add(R.id.fl_container, informationFragment);
                        } else {
                            ft.show(informationFragment);
                        }
                        break;
                    case 2:
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            ft.add(R.id.fl_container, mineFragment);
                        } else {
                            ft.show(mineFragment);
                        }
                        break;
                    default:
                        break;
                }
                ft.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {     //判断当前是否点击的是back键
            exitSystemByDoubleClick();
        }
        return false;
    }

    /**
     * 是否双击退出应用程序
     */
    private boolean isExit = false;

    /**
     * 双击退出应用程序
     */
    private void exitSystemByDoubleClick() {
        Timer timer;
        if (!isExit) {
            isExit = true;
            ToastUtils.showShort("再按一次退出程序");
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; //取消退出
                }
            }, 2000);       // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantFinal.MODIFY_PASSWORD_REQUEST_CODE && resultCode == ConstantFinal.MODIFY_PASSWORD_RESULT_CODE) {
            bottomNavigationBar.selectTab(0);//修改密码成功, 点击返回首页
            SPUtils.putBoolean(UserInfo.IS_LOGIN.name(), false);
            SPUtils.putBoolean(UserInfo.IS_DATA_REPORT.name(), false);
            SPUtils.putBoolean(UserInfo.IS_STATISTICAL_ANALYSIS.name(), false);
            SPUtils.putString(UserInfo.USER_ICON.name(), "");
            SPUtils.putString(UserInfo.USER_ICON_FIRST_HALF.name(), "");
        }
    }
}
