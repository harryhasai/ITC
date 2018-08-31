package com.hengkai.itc.function.activity_list;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hengkai.itc.R;
import com.hengkai.itc.network.entity.ActivityListEntity;
import com.hengkai.itc.utils.DateFormatUtils;

import java.util.List;

/**
 * Created by Harry on 2018/8/31.
 */
public class ActivityListAdapter extends BaseQuickAdapter<ActivityListEntity.DataBean, BaseViewHolder> {

    public ActivityListAdapter(int layoutResId, @Nullable List<ActivityListEntity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ActivityListEntity.DataBean item) {
        String time = DateFormatUtils.getFormatedDateTime(DateFormatUtils.PATTERN_3, item.createTime);
        helper.setText(R.id.tv_title, item.activityName)
                .setText(R.id.tv_content, "\u3000\u3000" + item.activityIntro)
                .setText(R.id.tv_time, time);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < item.activityStartTime) {
            helper.setImageResource(R.id.iv_status, R.drawable.ic_activity_list_preheating);
        } else if (currentTimeMillis >= item.activityStartTime && currentTimeMillis <= item.activityEndTime) {
            helper.setImageResource(R.id.iv_status, R.drawable.ic_activity_list_running);
        } else if (currentTimeMillis > item.activityEndTime) {
            helper.setImageResource(R.id.iv_status, R.drawable.ic_activity_list_ending);
        }
    }
}
