package com.boyue.boyuelauncher.settings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.settings.entity.MenuBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class SystemSettingIndicatorgAdapter extends BaseAdapter {

    private Context mContext;
    private List<MenuBean> menuBeanEntities;
    private LayoutInflater inflater;
    private int mCurrentItem = 0;
    private boolean isClick = false;
    private int iconWidth;
    private int iconHigh;


    public SystemSettingIndicatorgAdapter(Context mContext, int iconWidth, int iconHigh) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.iconWidth = iconWidth;
        this.iconHigh = iconHigh;
    }


    public void setAppEntities(List<MenuBean> menuBeanEntities) {
        this.menuBeanEntities = menuBeanEntities;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return menuBeanEntities == null ? 0 : menuBeanEntities.size() > 0 ? menuBeanEntities.size() : 0;
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
            convertView = inflater.inflate(R.layout.item_system_setting_indicator, null);
            viewHolder = new ViewHolder();
            viewHolder.ll = convertView.findViewById(R.id.page_item_ll);
            viewHolder.iv = convertView.findViewById(R.id.page_item_iv);
            viewHolder.tv = convertView.findViewById(R.id.page_item_tv);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        MenuBean menu = menuBeanEntities.get(position);

        Glide.with(mContext).load(menu.getIconRes()).override(iconWidth, iconHigh).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.iv);
        viewHolder.tv.setText(menu.getNameRes());

        if (mCurrentItem == position && isClick) {
            viewHolder.ll.setBackgroundColor(mContext.getResources().getColor(R.color.color_d3));
        } else {
            viewHolder.ll.setBackgroundColor(mContext.getResources().getColor(R.color.color_ea));
        }
        return convertView;
    }


    public void setmCurrentItem(int mCurrentItem) {
        this.mCurrentItem = mCurrentItem;
        notifyDataSetChanged();
    }

    public void setClick(boolean isClick) {
        this.isClick = isClick;
    }

    class ViewHolder {
        RelativeLayout ll;
        ImageView iv;
        TextView tv;
    }
}
