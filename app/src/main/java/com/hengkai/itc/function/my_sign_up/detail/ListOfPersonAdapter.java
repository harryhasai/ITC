package com.hengkai.itc.function.my_sign_up.detail;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.hengkai.itc.R;
import com.hengkai.itc.app_final.URLFinal;
import com.hengkai.itc.app_final.UserInfo;
import com.hengkai.itc.network.entity.CommonEntity;
import com.hengkai.itc.network.entity.ListOfPersonEntity;
import com.hengkai.itc.utils.OkHttpHelper;
import com.hengkai.itc.utils.SPUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Harry on 2018/9/7.
 */
public class ListOfPersonAdapter extends RecyclerView.Adapter<ListOfPersonAdapter.ViewHolder> {

    private List<String> nameList;
    private List<String> phoneList;
    private Activity mActivity;
    private int activityID;

    public ListOfPersonAdapter(List<String> nameList, List<String> phoneList, Activity activity, int activityID) {
        this.nameList = nameList;
        this.phoneList = phoneList;
        this.activityID = activityID;
        mActivity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_of_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.tvName.setText(nameList.get(position));
        holder.tvPhone.setText(phoneList.get(position));

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                builder.setMessage("是否删除");
                builder.setTitle("提示");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setupData(dialog, holder.getAdapterPosition());
                    }
                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }

    private void setupData(final DialogInterface dialog, int adapterPosition) {

        nameList.remove(adapterPosition);
        phoneList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);

        StringBuilder stringBuilder = new StringBuilder();
        for (String name : nameList) {
            stringBuilder.append(name);
            stringBuilder.append(",");
        }
        String name = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);

        StringBuilder stringBuilder1 = new StringBuilder();
        for (String phone : phoneList) {
            stringBuilder1.append(phone);
            stringBuilder1.append(",");
        }
        String phone = stringBuilder1.toString().substring(0, stringBuilder1.toString().length() - 1);

        Map<String, String> params = new HashMap<>();
        params.put("UserId", SPUtils.getString(UserInfo.USER_ID.name(), ""));
        params.put("EventId", String.valueOf(activityID));
        params.put("ApplyName", name);
        params.put("ApplyPhone", phone);
        OkHttpHelper.post(URLFinal.BASE_URL + URLFinal.DELETE_LIST_OF_PERSON, params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showShort("网络连接错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                if (!TextUtils.isEmpty(s)) {
                    Gson gson = new Gson();
                    CommonEntity commonEntity = gson.fromJson(s, CommonEntity.class);
                    switch (commonEntity.code) {
                        case 1:
                            dialog.dismiss();
                            ToastUtils.showShort("删除成功");
                            break;
                        case 0:
                            ((ListOfPersonActivity) mActivity).showLoginDialog(mActivity);
                            break;
                        default:
                            ToastUtils.showShort(commonEntity.msg);
                            break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPhone;
        ImageView ivDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            ivDelete = itemView.findViewById(R.id.iv_delete);
        }
    }

}
