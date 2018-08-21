package com.hengkai.itc.function.common_question;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/16.
 * 常见问题
 */
public class CommonQuestionActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.tv_answer)
    TextView tvAnswer;
    @BindView(R.id.ll_item)
    LinearLayout llItem;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    @Override
    protected int setupView() {
        return R.layout.activity_common_question;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        tvTitle.setText("常见问题");
        addChild();

    }

    private void addChild() {
        for (int i = 0; i < 4; i++) {
            View view = View.inflate(this, R.layout.view_common_question_item, null);
            llContainer.addView(view);
        }
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
