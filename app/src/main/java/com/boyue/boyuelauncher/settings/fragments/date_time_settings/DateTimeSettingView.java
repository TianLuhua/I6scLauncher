package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import com.boyue.boyuelauncher.base.BaseView;

import java.util.Date;

public interface DateTimeSettingView extends BaseView {

    void isDateTimeAuto(boolean isAuto);

    void onSuccess( );

    void onFail();
}
