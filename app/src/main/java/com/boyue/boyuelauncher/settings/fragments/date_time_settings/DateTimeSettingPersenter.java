package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.content.Context;

import com.boyue.boyuelauncher.base.AbstractPresenter;

import java.util.Date;

public class DateTimeSettingPersenter extends AbstractPresenter<DateTimeSettingView> {

    private DateTimeSettingMode mode;

    public DateTimeSettingPersenter(Context mContext) {
        this.mode = new DateTimeSettingMode(mContext, new DateTimeSettingMode.CallBack() {


            @Override
            public void setIsDateTimeAuto(boolean isAuto) {
                DateTimeSettingView view = getView();
                if (view == null) return;
                view.isDateTimeAuto(isAuto);
            }

            @Override
            public void setSuccess( ) {
                getView().onSuccess();
            }

            @Override
            public void setFail() {
                getView().onFail();
            }
        });
    }

    public void getIsDateTimeAuto() {
        if (mode == null) return;
        mode.getIsDateTimeAuto();
    }

    public void setAutoDateTime(boolean autoDateTime) {
        if (mode == null) return;
        mode.setAutoDateTime(autoDateTime);
    }

    public void setSysTime(int hour, int minute) {
        if (mode == null) return;
        mode.setSysTime(hour, minute);

    }

    public void setSysDate(int year, int month, int day) {
        if (mode == null) return;
        mode.setSysDate(year, month, day);
    }


}
