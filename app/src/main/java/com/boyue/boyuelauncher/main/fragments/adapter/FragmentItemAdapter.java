package com.boyue.boyuelauncher.main.fragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class FragmentItemAdapter extends BaseAdapter {


    private Context mContext;
    private List<APPEntity> appEntities;
    private LayoutInflater inflater;

    public FragmentItemAdapter(Context mContext) {
        this.mContext = mContext;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.appEntities = new ArrayList<>();
    }


    public void setAppEntities(List<APPEntity> appEntities) {
        this.appEntities = appEntities;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return appEntities == null ? 0 : appEntities.size() > 0 ? appEntities.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout_main_grideview, null);
            viewHolder = new ViewHolder();
            viewHolder.iv = convertView.findViewById(R.id.icon);
            viewHolder.tv = convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        APPEntity appEntitie = appEntities.get(position);

        Glide.with(mContext).load(appEntitie.getIconRes()).override(122, 125).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.iv);

        viewHolder.tv.setText(appEntitie.getNameRes());
        return convertView;
    }


    public class ViewHolder {
        ImageView iv;
        TextView tv;
    }

}
