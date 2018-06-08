package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.content.Context;

import com.boyue.boyuelauncher.base.AbstractPresenter;

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
}
