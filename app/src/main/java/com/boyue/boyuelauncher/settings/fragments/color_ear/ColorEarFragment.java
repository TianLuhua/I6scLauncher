package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.ToastUtil;

public class ColorEarFragment extends AbstractMVPFragment<ColorEarView, ColorEarPersenter> implements ColorEarView, CheckBox.OnCheckedChangeListener {

    //七彩耳灯
    private CheckBox colorEarSwitch;
    private TextView itemTitle;


    public static ColorEarFragment newInstance() {
        return new ColorEarFragment();
    }

    public ColorEarFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_color_ear, null, false);
        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {
        colorEarSwitch = rootview.findViewById(R.id.item_group);
        colorEarSwitch.setOnCheckedChangeListener(this);
        itemTitle = rootview.findViewById(R.id.item_title);
        itemTitle.setText(R.string.color_ear);
        getPresenter().getColorEarStatus();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ToastUtil.showToast(isChecked ? "on" : "off", Toast.LENGTH_SHORT);
        getPresenter().setColorEarStatus(isChecked);

    }


    @Override
    protected ColorEarPersenter createPresenter() {
        return new ColorEarPersenter(getContext().getApplicationContext());
    }

    @Override
    public void setColorEarStatus(boolean isOpen) {
        if (colorEarSwitch == null) return;
        colorEarSwitch.setChecked(isOpen);

    }
}
