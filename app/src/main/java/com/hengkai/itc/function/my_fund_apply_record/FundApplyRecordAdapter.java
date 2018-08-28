package com.hengkai.itc.function.my_fund_apply_record;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
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

    public FundApplyRecordAdapter(int layoutResId, @Nullable List<FundApplyRecordEntity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FundApplyRecordEntity.DataBean item) {
        String status = "";
        switch (item.status) {
            case "0": //0已拒绝，1已通过，2未审核
                status = "已拒绝";
                displayOrHidden(helper, true);
                break;
            case "1":
                status = "已通过";
                displayOrHidden(helper, true);
                break;
            case "2":
                status = "未审核";
                displayOrHidden(helper, false);
                break;
        }
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_1, item.updatetime);
        helper.setText(R.id.tv_apply_user, item.applyuser)
                .setText(R.id.tv_status, status)
                .setText(R.id.tv_apply_content, item.applycontent)
                .setText(R.id.tv_examine_user, item.examineuser)
                .setText(R.id.tv_examine_time, time)
                .setText(R.id.tv_examine_content, item.examineContent);
    }

    private void displayOrHidden(BaseViewHolder helper, boolean isDisplay) {
        TextView tv_examine_user = helper.getView(R.id.tv_examine_user);
        TextView tv_examine_time = helper.getView(R.id.tv_examine_time);
        TextView tv_examine_content = helper.getView(R.id.tv_examine_content);
        View view_line = helper.getView(R.id.view_line);
        if (isDisplay) {
            tv_examine_user.setVisibility(View.VISIBLE);
            tv_examine_time.setVisibility(View.VISIBLE);
            tv_examine_content.setVisibility(View.VISIBLE);
            view_line.setVisibility(View.VISIBLE);
        } else {
            tv_examine_user.setVisibility(View.GONE);
            tv_examine_time.setVisibility(View.GONE);
            tv_examine_content.setVisibility(View.GONE);
            view_line.setVisibility(View.GONE);
        }
    }
}
