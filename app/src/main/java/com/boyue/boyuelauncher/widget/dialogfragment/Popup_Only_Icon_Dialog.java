package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;

public abstract class Popup_Only_Icon_Dialog extends DialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootVire = inflater.inflate(R.layout.dialog_popup_only_icon_lable, null, false);
        initView(rootVire);
        return rootVire;
    }

    private void initView(View rootVire) {
        ImageView icon = rootVire.findViewById(R.id.icon);
        icon.setImageResource(getIconRes());
        TextView lable = rootVire.findViewById(R.id.lable);
        lable.setText(getLableRes());
    }

    //设置图标
    protected abstract int getIconRes();

    //设置提示语
    protected abstract int getLableRes();

}
