package com.hengkai.itc.function.activity_list_detail.sign_up;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baoyz.actionsheet.ActionSheet;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.utils.QRCodeUtil;
import com.hengkai.itc.utils.SPUtils;
import com.jaeger.library.StatusBarUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Harry on 2018/8/31.
 * 资讯 - 活动列表详情 - 活动报名
 */
public class SignUpActivity extends BaseActivity implements View.OnLongClickListener, ActionSheet.ActionSheetListener, EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_PHONE_STATE = 1001;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    private String url;
    private Bitmap bitmap;

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
        url = URLFinal.QR_CODE_URL + "UserId=" + userID + "&EventId=" + activityID;
        bitmap = QRCodeUtil.createQRCodeBitmap(url, 480, 480);
        ivImage.setImageBitmap(bitmap);
        ivImage.setOnLongClickListener(this);

        ivRight.setImageDrawable(getResources().getDrawable(R.drawable.menu));
        ivRight.setVisibility(View.VISIBLE);
    }



    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick({R.id.iv_back,R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right:
                onLongClick(view);
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("取消")
                .setOtherButtonTitles("保存到相册", "识别二维码")
                .setCancelableOnTouchOutside(true)
                .setListener(this).show();
        return false;
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {}

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        switch (index){
            case 0:
                checkPermission();
                break;
            case 1:
                scanQr();
                break;
        }
    }

    private void saveImageToCamera(){
        // 首先保存图片
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + getPackageName() + File.separator ;
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            boolean isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            fos.flush();
            fos.close();

            // 把文件插入到系统图库
            // MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), fileName, null);

            //保存图片后发送广播通知更新数据库
            Uri uri = Uri.fromFile(file);
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            if (isSuccess) {
                ToastUtils.showLong("二维码保存成功");
            } else {
                ToastUtils.showLong("二维码保存失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanQr(){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void checkPermission() {
        String[] permissionList = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= 23) {
            if (EasyPermissions.hasPermissions(this, permissionList)) {
                saveImageToCamera();
            } else {
                EasyPermissions.requestPermissions(this, "需要读取手机状态的权限, 如果拒绝可能造成无法正常登陆", REQUEST_PHONE_STATE, permissionList);
            }
        } else {
            saveImageToCamera();
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
        saveImageToCamera();
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
            checkPermission();
        }
    }
}
