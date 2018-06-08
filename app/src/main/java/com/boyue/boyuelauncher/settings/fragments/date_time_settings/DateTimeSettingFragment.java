package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.pickdate.OnChangeLisener;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_SetDateDialog;
import com.boyue.boyuelauncher.widget.pickdate.OnSureLisener;
import com.boyue.boyuelauncher.widget.pickdate.bean.DateType;

import java.util.Date;

public class DateTimeSettingFragment extends AbstractMVPFragment<DateTimeSettingView, DateTimeSettingPersenter> implements DateTimeSettingView, CompoundButton.OnCheckedChangeListener, View.OnClickListener, OnChangeLisener, OnSureLisener {

    private CheckBox synchronizationTimeSwitch;
    private TextView dateText;
    private TextView timeText;
    private FragmentManager manager;

    public static DateTimeSettingFragment newInstance() {
        return new DateTimeSettingFragment();
    }

    public DateTimeSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_date_time_setting, null, false);
        initView(rootview);
        return rootview;
    }

    private void initView(View rootview) {
        manager = getFragmentManager();
        synchronizationTimeSwitch = rootview.findViewById(R.id.synchronization_time_switch);
        synchronizationTimeSwitch.setOnCheckedChangeListener(this);
        dateText = rootview.findViewById(R.id.set_date_value);
        timeText = rootview.findViewById(R.id.set_time_value);
        dateText.setOnClickListener(this);
        timeText.setOnClickListener(this);
        getPresenter().getIsDateTimeAuto();
    }

    @Override
    protected DateTimeSettingPersenter createPresenter() {
        return new DateTimeSettingPersenter(getContext());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.synchronization_time_switch:
                setDateAndTime(isChecked);
                getPresenter().setAutoDateTime(isChecked);
                break;
        }

    }

    private void setDateAndTime(boolean isChecked) {

        dateText.setTextAppearance(getActivity().getApplicationContext(), !isChecked ? R.style.Stlye_system_setting_date_time_enable : R.style.Stlye_system_setting_date_time_disable);
        timeText.setTextAppearance(getActivity().getApplicationContext(), !isChecked ? R.style.Stlye_system_setting_date_time_enable : R.style.Stlye_system_setting_date_time_disable);
        dateText.setClickable(!isChecked);
        timeText.setClickable(!isChecked);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //设置日期
            case R.id.set_date_value:
                //防止选择日期dialog出现多次
                if (manager.findFragmentByTag("date") == null) {

                    Setting_SetDateDialog dateDialog = new Setting_SetDateDialog();
                    dateDialog.setType(DateType.TYPE_YMD);
                    dateDialog.setTitleRes(R.string.set_date);
                    dateDialog.setLeftBtnRes(R.string.cancel);
                    dateDialog.setRightBtnRes(R.string.ok);
                    dateDialog.setOnChangeLisener(this);
                    dateDialog.setOnSureLisener(this);
                    dateDialog.show(getActivity().getSupportFragmentManager(), "date");
                }
                break;

            //设置时间
            case R.id.set_time_value:
                //防止选择时间dialog出现多次
                if (manager.findFragmentByTag("time") == null) {
                    Setting_SetDateDialog timeDialog = new Setting_SetDateDialog();
                    timeDialog.setType(DateType.TYPE_HM);
                    timeDialog.setTitleRes(R.string.set_time);
                    timeDialog.setLeftBtnRes(R.string.cancel);
                    timeDialog.setRightBtnRes(R.string.ok);
                    timeDialog.setOnChangeLisener(this);
                    timeDialog.setOnSureLisener(this);
                    timeDialog.show(getActivity().getSupportFragmentManager(), "time");
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void onChanged(Date date) {
        LogUtils.e("tlh", "onChanged---date:" + date.toString());

    }

    @Override
    public void onSure(Date date) {
        LogUtils.e("tlh", "onSure---date:" + date.toString());
    }

    @Override
    public void isDateTimeAuto(boolean isAuto) {
        if (synchronizationTimeSwitch == null) return;
        LogUtils.e("tlh", "isDateTimeAuto:" + isAuto);
        synchronizationTimeSwitch.setChecked(isAuto);
        setDateAndTime(isAuto);
    }
}
