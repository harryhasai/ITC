package com.hengkai.itc.function.data_report;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hengkai.itc.R;
import com.hengkai.itc.base.BaseActivity;
import com.hengkai.itc.base.presenter.BasePresenter;
import com.hengkai.itc.network.entity.CommonItem;
import com.jaeger.library.StatusBarUtil;
import com.ruffian.library.RTextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harry on 2018/8/18.
 * 数据上报
 */
public class DataReportActivity extends BaseActivity<DataReportPresenter> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_year)
    RTextView tvYear;
    @BindView(R.id.tv_month)
    RTextView tvMonth;
    @BindView(R.id.et_employee_count)
    EditText etEmployeeCount;
    @BindView(R.id.et_income)
    EditText etIncome;
    @BindView(R.id.et_contract_count)
    EditText etContractCount;
    @BindView(R.id.et_patent_count)
    EditText etPatentCount;
    @BindView(R.id.et_yx_count)
    EditText etYxCount;
    @BindView(R.id.et_dz_count)
    EditText etDzCount;
    @BindView(R.id.et_bk_count)
    EditText etBkCount;
    @BindView(R.id.et_ys_count)
    EditText etYsCount;

    @Override
    protected int setupView() {
        return R.layout.activity_data_report;
    }

    @Override
    protected void initView() {
        //设置沉浸式状态栏, 参数2: 颜色, 参数3: 透明度(0-255, 0表示透明, 255不透明)
        StatusBarUtil.setColor(this, getResources().getColor(R.color.title_bar_bg), 0);
        ButterKnife.bind(this);
        tvTitle.setText("数据上报");

    }

    @Override
    protected DataReportPresenter bindPresenter() {
        return new DataReportPresenter();
    }

    @OnClick({R.id.iv_back, R.id.tv_year, R.id.tv_month, R.id.btn_commit})
    public void onViewClicked(View view) {
        List<CommonItem> data;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_year:
                data = new ArrayList<>();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                data.add(new CommonItem(String.valueOf(year - 1)));
                data.add(new CommonItem(String.valueOf(year)));
                data.add(new CommonItem(String.valueOf(year + 1)));
                showYearOrMonthDialog(true, data);
                break;
            case R.id.tv_month:
                data = new ArrayList<>();
                for (int i = 1; i < 13; i++) {
                    data.add(new CommonItem(String.valueOf(i)));
                }
                showYearOrMonthDialog(false, data);
                break;
            case R.id.btn_commit:
                dataReport();
                break;
        }
    }

    /**
     * 提交数据
     */
    private void dataReport() {
        String year = tvYear.getText().toString().trim();
        String month = tvMonth.getText().toString().trim();
        String employeeCount = etEmployeeCount.getText().toString().trim();
        String income = etIncome.getText().toString().trim();
        String contractCount = etContractCount.getText().toString().trim();
        String patentCount = etPatentCount.getText().toString().trim();
        String yxCount = etYxCount.getText().toString().trim();
        String dzCount = etDzCount.getText().toString().trim();
        String bkCount = etBkCount.getText().toString().trim();
        String ysCount = etYsCount.getText().toString().trim();
        if (TextUtils.isEmpty(year) || year.equals("选择年份")) {
            ToastUtils.showShort("请选择年份");
            return;
        } else if (TextUtils.isEmpty(month) || month.equals("选择月份")) {
            ToastUtils.showShort("请选择年份");
            return;
        } else if (TextUtils.isEmpty(employeeCount)) {
            ToastUtils.showShort("请输入人员总数");
            return;
        } else if (TextUtils.isEmpty(income)) {
            ToastUtils.showShort("请输入营收");
            return;
        } else if (TextUtils.isEmpty(contractCount)) {
            ToastUtils.showShort("请输入新增合同数");
            return;
        }else if (TextUtils.isEmpty(patentCount)) {
            ToastUtils.showShort("请输入新增专利或者软著数");
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        params.put("personTotal", employeeCount);
        params.put("revenue", income);
        params.put("newContractCount", contractCount);
        params.put("patent", patentCount);
        params.put("collegeDegreeBelow", yxCount);
        params.put("collegeDegree", dzCount);
        params.put("undergraduate", bkCount);
        params.put("undergraduateAbove", ysCount);

        mPresenter.dataReport(params);
    }

    /**
     * 配置选择年或者选择月的弹窗
     */
    private void showYearOrMonthDialog(boolean isYear, List<CommonItem> data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.dialog_data_report, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        setupChildView(dialog, view, data, isYear);
        dialog.show();
    }

    /**
     * 配置弹窗的子view
     *
     * @param dialog 父dialog
     * @param view   子view
     */
    private void setupChildView(final AlertDialog dialog, View view, final List<CommonItem> data, final boolean isYear) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DataReportDialogAdapter adapter = new DataReportDialogAdapter(R.layout.item_data_report_dialog, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isYear) {
                    tvYear.setText(data.get(position).name);
                    tvYear.setTextColor(Color.parseColor("#333333"));
                } else {
                    tvMonth.setText(data.get(position).name);
                    tvMonth.setTextColor(Color.parseColor("#333333"));
                }
                dialog.dismiss();
            }
        });
    }

}
