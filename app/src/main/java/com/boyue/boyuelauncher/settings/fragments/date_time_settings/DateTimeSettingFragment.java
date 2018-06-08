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
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.pickdate.OnChangeLisener;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_SetDateDialog;
import com.boyue.boyuelauncher.widget.pickdate.OnSureLisener;
import com.boyue.boyuelauncher.widget.pickdate.bean.DateType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeSettingFragment extends AbstractMVPFragment<DateTimeSettingView, DateTimeSettingPersenter> implements DateTimeSettingView, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox synchronizationTimeSwitch;
    private TextView dateText;
    private TextView timeText;
    private FragmentManager manager;

    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");

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
        updateUI();
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
                updateUI();
                break;
        }

    }

    private void setDateAndTime(boolean isChecked) {

        dateText.setTextAppearance(getActivity().getApplicationContext(), !isChecked ? R.style.Stlye_system_setting_date_time_enable : R.style.Stlye_system_setting_date_time_disable);
        timeText.setTextAppearance(getActivity().getApplicationContext(), !isChecked ? R.style.Stlye_system_setting_date_time_enable : R.style.Stlye_system_setting_date_time_disable);
        dateText.setClickable(!isChecked);
        timeText.setClickable(!isChecked);
    }

    /**
     * 根据当前时间，更新UI
     */
    private void updateUI() {
        Date date = new Date(System.currentTimeMillis());
        String[] ss = simpleDateFormat.format(date).split("_");
        dateText.setText(ss[0]);
        timeText.setText(ss[1]);
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
                    dateDialog.setOnSureLisener(new OnSureLisener() {
                        @Override
                        public void onSure(Date date) {
                            String dd = dateFormat.format(date);
                            String[] ss = dd.split("-");
                            getPresenter().setSysDate(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), Integer.valueOf(ss[1]));
                            updateUI();
                        }
                    });
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
                    timeDialog.setOnSureLisener(new OnSureLisener() {
                        @Override
                        public void onSure(Date date) {
                            String dd = timeFormat.format(date);
                            String[] ss = dd.split(":");
                            getPresenter().setSysTime(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]));
                            updateUI();
                        }
                    });
                    timeDialog.show(getActivity().getSupportFragmentManager(), "time");
                }
                break;
            default:
                break;
        }

    }


    @Override
    public void isDateTimeAuto(boolean isAuto) {
        if (synchronizationTimeSwitch == null) return;
        synchronizationTimeSwitch.setChecked(isAuto);
        setDateAndTime(isAuto);
    }

    @Override
    public void onSuccess() {
        ToastUtil.showLongToast(R.string.set_time_success);
    }


    @Override
    public void onFail() {
        ToastUtil.showLongToast(R.string.set_time_fail);
    }

}
