package com.boyue.boyuelauncher.wifimanager.adpter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.DataActionListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Wifi适配器
 * Created by tianluhua on 2018/5/11.
 */

public class WifiAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<WifiModel> dataList;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private DataActionListener dataActionListener;

    public WifiAdapter(Context context) {
        this.context = context;
        this.dataList = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }
    public void setDataList(ArrayList<WifiModel> dataList){
        this.dataList=dataList;
        notifyDataSetChanged();
    }

    public void clear(){
        if (dataList==null)return;
        dataList.clear();
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setDataActionListener(DataActionListener dataActionListener) {
        this.dataActionListener = dataActionListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_wifimanager_item_wifi, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof CustomViewHolder) {
            CustomViewHolder viewHolder = (CustomViewHolder) holder;
            final WifiModel data = dataList.get(position);
            viewHolder.tvWifiName.setText(data.getWifiName());
            if (data.isShowDetail()) {
//                viewHolder.ivDetail.setText(R.string.icon_up);
                viewHolder.tvWifiDetail.setVisibility(View.VISIBLE);
                viewHolder.tvWifiDetail.setText(data.getWifiDetail());
            } else {
//                viewHolder.ivDetail.setText(R.string.icon_down);
                viewHolder.tvWifiDetail.setVisibility(View.GONE);
            }
            if (data.getWifiType() != 0) {

                //需要密码连接
//                viewHolder.ivNeedCode.setVisibility(View.VISIBLE);
            } else {
                //不需要需要密码连接

//                viewHolder.ivNeedCode.setVisibility(View.INVISIBLE);
            }
            viewHolder.ivIgnore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dataActionListener != null) {
                        dataActionListener.onIgnore(position);
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
            if (data.isConnect()) {
//                viewHolder.ivIntensity.setTextColor(ContextCompat.getColor(context, R.color.font_green));
            } else {
//                viewHolder.ivIntensity.setTextColor(ContextCompat.getColor(context, R.color.font_text));
            }
            viewHolder.ivIntensity.getDrawable().setLevel(data.getIntensity());

        }
    }

    @Override
    public int getItemCount() {
        LogUtils.e("tll","dataList:"+dataList.size());
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tvWifiName;
        TextView tvWifiDetail;
        ImageView ivIntensity;
        ImageView ivIgnore;
        //        TextView ivNeedCode;
//        TextView ivDetail;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvWifiName = itemView.findViewById(R.id.wifi_name);
            tvWifiDetail = itemView.findViewById(R.id.tvWifiDetail);
            ivIntensity = itemView.findViewById(R.id.wifi_ic);
            ivIgnore = itemView.findViewById(R.id.ignore_ic);
//            ivNeedCode = itemView.findViewById(R.id.ivNeedCode);
//            ivDetail = itemView.findViewById(R.id.ivDetail);
        }
    }
}
