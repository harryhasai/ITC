package com.hengkai.itc.function.my_fund_apply_record;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.FundApplyRecordEntity;
import com.hengkai.itc.utils.DateFormatUtils;

import java.util.List;

/**
 * Created by Harry on 2018/8/27.
 */
public class FundApplyRecordAdapter extends BaseQuickAdapter<FundApplyRecordEntity.DataBean, BaseViewHolder> {

    private List<FundApplyRecordEntity.DataBean> data;

    public FundApplyRecordAdapter(int layoutResId, @Nullable List<FundApplyRecordEntity.DataBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, FundApplyRecordEntity.DataBean item) {
        String status = "";
        switch (item.status) {
            case "0": //0已拒绝，1已通过，2未审核
                status = "审核未通过";
                helper.setBackgroundRes(R.id.tv_status, R.drawable.shape_fund_apply_record_gray);
                break;
            case "1":
                status = "审核通过";
                helper.setBackgroundRes(R.id.tv_status, R.drawable.shape_fund_apply_record_green);
                break;
            case "2":
                status = "审核中";
                helper.setBackgroundRes(R.id.tv_status, R.drawable.shape_fund_apply_record_yellow);
                break;
        }
        String updateTime = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, item.updatetime);
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, item.createtime);
        helper.setText(R.id.tv_time, time)
                .setText(R.id.tv_status, status)
                .setText(R.id.tv_fund_title, item.fundname);

        if (TextUtils.isEmpty(item.examineuser)) {
            helper.setText(R.id.tv_examine_user, "审核人: 暂无");
        } else {
            helper.setText(R.id.tv_examine_user, "审核人: " + item.examineuser);
        }
        if (item.updatetime == 0) {
            helper.setText(R.id.tv_examine_time, "审核时间: 暂无");
        } else {
            helper.setText(R.id.tv_examine_time, "审核时间: " + updateTime);
        }
        if (TextUtils.isEmpty(item.examineContent)) {
            helper.setText(R.id.tv_examine_content, "审核内容: 暂无");
        } else {
            helper.setText(R.id.tv_examine_content, "\u3000\u3000" + item.examineContent);
        }

        ImageView ivLine = helper.getView(R.id.iv_line);
        if (helper.getAdapterPosition() == data.size() - 1) {
            ivLine.setVisibility(View.INVISIBLE);
        } else {
            ivLine.setVisibility(View.VISIBLE);
        }
        if (helper.getAdapterPosition() == 0) {
            ImageView ivLine1 = helper.getView(R.id.iv_line1);
            ivLine1.setVisibility(View.INVISIBLE);
        }
    }

}
