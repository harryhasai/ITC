package com.hengkai.itc.function.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseFragment;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.function.my_comment.MyCommentActivity;
import com.hengkai.itc.utils.ImageUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Harry on 2018/8/14.
 * 我的
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.tv_name)
    TextView tvName;
    Unbinder unbinder;

    @Override
    protected int setupView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 初始化页面信息
     */
    private void initUserInfo() {

//        Picasso.with(mActivity)
//                .load(SPUtils.getString(UserInfo.ICON_LINK.name(), ""))
//                .error(R.drawable.ic_user)
//                .transform(new PicassoCircleTransform())
//                .resize(WindowUtil.dp2px(50, mActivity), WindowUtil.dp2px(50, mActivity))
//                .centerCrop()
//                .into(ivUserHeader);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_header, R.id.tv_comment, R.id.tv_reply, R.id.tv_sign_up, R.id.fl_data_report,
            R.id.fl_statistical_analysis, R.id.fl_modify_password, R.id.fl_exit_logon, R.id.fl_service_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_header:    //头像
                changeHeaderImage();
                break;
            case R.id.tv_comment:   //我的评论
                startActivity(new Intent(mActivity, MyCommentActivity.class));
                break;
            case R.id.tv_reply:     //回复我的
                break;
            case R.id.tv_sign_up:   //我的报名
                break;
            case R.id.fl_data_report:   //数据上报
                break;
            case R.id.fl_service_comment:   //服务评价
                break;
            case R.id.fl_statistical_analysis://统计分析
                break;
            case R.id.fl_modify_password://修改密码
                break;
            case R.id.fl_exit_logon:    //退出登录
                break;
        }
    }

    /**
     * 修改用户头像
     */
    private void changeHeaderImage() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(1)// 最大图片选择数量 int
//                .minSelectNum()// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(false)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
//                .glideOverride()// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif()// 是否显示gif图片 true or false
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(true)// 是否圆形裁剪 true or false
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(true)// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs()// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
//                .compressMaxKB()//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH() // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                .rotateEnabled(false) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoSecond()// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureConfig.CHOOSE_REQUEST) {//修改头像 结果回调
            if (data == null) {
                return; //什么都不选择, 直接点击返回或者取消按钮的时候return掉
            }
            List<LocalMedia> medias = PictureSelector.obtainMultipleResult(data);
            // 1.media.getPath(); 为原图path
            // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
            // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
            // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
            String compressPath = medias.get(0).getCompressPath();
            String base64 = ImageUtil.image2Base64(compressPath);

        }
    }
}
