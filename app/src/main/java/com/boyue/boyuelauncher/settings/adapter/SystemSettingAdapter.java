package com.boyue.boyuelauncher.settings.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.settings.SettingsActivity;

import java.util.List;
import java.util.Map;

public class SystemSettingAdapter extends SimpleAdapter {

    private Context context;
    private LayoutInflater inflater;

    private int mCurrentItem = 0;
    private boolean isClick = false;

    private List<Map<String, Object>> data;

    public SystemSettingAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = (List<Map<String, Object>>) data;
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
        Map<String, Object> mapItem = data.get(position);
        viewHolder.iv.setImageResource((Integer) mapItem.get(SettingsActivity.IMAGE));
        viewHolder.tv.setText((CharSequence) mapItem.get(SettingsActivity.TITLE));
        if (mCurrentItem == position && isClick) {
            viewHolder.ll.setBackgroundColor(Color.parseColor("#e9cfdd"));
        } else {
            viewHolder.ll.setBackgroundColor(Color.parseColor("#f6e4ee"));
        }
        return convertView;

    }

    public void setmCurrentItem(int mCurrentItem) {
        this.mCurrentItem = mCurrentItem;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    class ViewHolder {
        RelativeLayout ll;
        ImageView iv;
        TextView tv;
    }
}
