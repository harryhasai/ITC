package com.hengkai.itc.function.common_question;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

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
        List<Bean> list = new ArrayList<>();
        Bean bean = new Bean();
        bean.question = "想要入驻园区,需要满足的条件是什么?";
        bean.answer = "为执行国家级孵化器在孵企业标准，控制进入园区的企业质量和类型，入园企业的基本条件如下：\n" +
                "（1）企业注册地及工作场所必须在科技园内；\n" +
                "（2）属新注册企业或申请进入科技园前企业成立时间原则上不超过3年；\n" +
                "（3）企业在园内孵化时间最短不低于两年，最长不超过五年；\n" +
                "（4）属迁入企业的，上年营业收入不超过200万元；\n" +
                "（5）入园企业（除中介机构外），原则上必须是科技型企业，其技术和产品属于国家颁布的高新技术范围或其他科技类型。\n";
        list.add(bean);
        bean = new Bean();
        bean.question = "企业入驻园区的流程是什么?";
        bean.answer = "（1）填写入园申请表\n" +
                "（2）递交入园所需企业资料\n" +
                "（3）签订入驻协议\n" +
                "（4）办理相关入驻手续(物业)";
        list.add(bean);
        bean = new Bean();
        bean.question = "入园企业可以享受什么优惠政策?";
        bean.answer = "（1）科技型中小企业备案\n" +
                "（2）科技小巨人、高企、重大专项\n" +
                "（3）产业基金投资\n" +
                "（4）其他相关优惠政策\n";
        list.add(bean);
        bean = new Bean();
        bean.question = "园区配套服务有哪些?";
        bean.answer = "（1）国家级软件公共技术服务平台\n" +
                "（2）300平会议室\n" +
                "（3）1.8万科技孵化面积\n";
        list.add(bean);

        for (int i = 0; i < list.size(); i++) {
            View view = View.inflate(this, R.layout.view_common_question_item, null);

            TextView tvQuestion = view.findViewById(R.id.tv_question);
            tvQuestion.setText(list.get(i).question);
            TextView tvAnswer = view.findViewById(R.id.tv_answer);
            tvAnswer.setText(list.get(i).answer);

            llContainer.addView(view);
        }
    }

    protected class Bean {
        protected String question;
        protected String answer;
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
