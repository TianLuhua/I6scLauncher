package com.boyue.boyuelauncher.wifimanager.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.DataActionListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnItemClickListener;

import java.util.ArrayList;

/**
 * Wifi适配器
 * Created by Tianluhua on 2018/6/11.
 */

public class WifiAdapter extends RecyclerView.Adapter {

    private ArrayList<WifiModel> dataList;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private DataActionListener dataActionListener;

    public WifiAdapter(Context context) {
        this.dataList = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(ArrayList<WifiModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    public void clear() {
        if (dataList == null) return;
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
            if (data.getWifiType() != 0) {
                //需要密码
                viewHolder.ivIntensity.setImageResource(R.drawable.level_list_settings_wifi_needpwd);
            } else {
                //不需要密码
                viewHolder.ivIntensity.setImageResource(R.drawable.level_list_settings_wifi);
            }
            //是否连接过，保存在系统中
            if (data.getConfiged()) {
                viewHolder.tvIsConofiged.setVisibility(View.VISIBLE);
                viewHolder.ivIgnore.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvIsConofiged.setVisibility(View.INVISIBLE);
                viewHolder.ivIgnore.setVisibility(View.INVISIBLE);
            }
            //是否是当前连接的WIFI
            if (data.isConnect()) {
                viewHolder.ivConnected.setVisibility(View.VISIBLE);
                viewHolder.tvIsConofiged.setVisibility(View.INVISIBLE);
                viewHolder.ivIgnore.setVisibility(View.VISIBLE);

            } else {
                viewHolder.ivConnected.setVisibility(View.INVISIBLE);
            }


            viewHolder.ivIgnore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dataActionListener != null) {
                        dataActionListener.onIgnore(data, position);
                    }
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(data, position);
                    }
                }
            });
            viewHolder.ivIntensity.getDrawable().setLevel(data.getIntensity());

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //wifi名字
        TextView tvWifiName;
        //是否已经连接过，保存到系统
        TextView tvIsConofiged;
        //图标
        ImageView ivIntensity;
        //已经连接
        ImageView ivConnected;
        //忽略网络按钮
        ImageView ivIgnore;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvWifiName = itemView.findViewById(R.id.wifi_name);
            tvIsConofiged = itemView.findViewById(R.id.wifi_has_saved);
            ivIntensity = itemView.findViewById(R.id.wifi_ic);
            ivConnected = itemView.findViewById(R.id.connected_ic);
            ivIgnore = itemView.findViewById(R.id.ignore_ic);
        }
    }
}
