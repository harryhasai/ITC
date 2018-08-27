package com.hengkai.itc.function.my_fund.detail;

import android.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.network.entity.MyFundDetailEntity;
import com.hengkai.itc.utils.DateFormatUtils;
import com.hengkai.itc.utils.EditTextFilterUtil;
import com.hengkai.itc.utils.SPUtils;
import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/27.
 * 基金列表详情
 */
public class MyFundDetailActivity extends BaseActivity<MyFundDetailPresenter> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_content_img)
    ImageView ivContentImg;
    @BindView(R.id.tv_content)
    TextView tvContent;
    /**
     * 报名的弹窗
     */
    private AlertDialog signUpDailog;
    private int fundID;

    @Override
    protected int setupView() {
        return R.layout.activity_my_fund_detail;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);

        tvTitle.setText("基金详情");
        tvRight.setText("报名");

        fundID = getIntent().getIntExtra("ID", 0);
        mPresenter.getFundDetail(fundID);
    }

    @Override
    protected MyFundDetailPresenter bindPresenter() {
        return new MyFundDetailPresenter();
    }

    public void getFundDetail(MyFundDetailEntity.DataBean bean) {

        if (!TextUtils.isEmpty(bean.coverImg)) {
            Picasso.with(this)
                    .load(SPUtils.getString(UserInfo.USER_ICON_FIRST_HALF.name(), "") + bean.coverImg)
                    .error(R.drawable.ic_news_default_pic)
//                        .transform(new PicassoCircleTransform())
//                        .resize(ConvertUtils.dp2px(40), ConvertUtils.dp2px(40))
//                        .centerCrop()
                    .into(ivContentImg);
        } else {
            ivContentImg.setImageResource(R.drawable.ic_news_default_pic);
        }

        tvNewsTitle.setText(bean.title);
        tvAuthor.setText(bean.createUser);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, bean.createTime);
        tvTime.setText(time);
        tvContent.setText(Html.fromHtml(bean.content));
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                showSignUpDialog();
                break;
        }
    }

    /**
     * 显示报名弹窗
     */
    private void showSignUpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.dialog_fund, null);
        final EditText etContent = view.findViewById(R.id.et_content);
        Button btnCommit = view.findViewById(R.id.btn_commit);
        builder.setView(view);
        signUpDailog = builder.create();

        etContent.setFilters(EditTextFilterUtil.addSpaceFiltering());
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etContent.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    ToastUtils.showShort("申请内容不能为空");
                    return;
                }
                mPresenter.signUp(fundID, content);
            }
        });

        signUpDailog.show();

    }

    /**
     * 报名成功后调用此方法
     */
    public void signUpSuccess() {
        signUpDailog.dismiss();
        ToastUtils.showShort("报名成功");
    }
}
