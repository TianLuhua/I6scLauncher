package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.Utils;

import static android.provider.Settings.System.SCREEN_OFF_TIMEOUT;


public class AutoShueDownMode implements BaseMode {

    private Context mContext;
    private CallBack callBack;
    private ContentResolver resolver;
    private SPUtils spUtils;

    public AutoShueDownMode(Context mContext, CallBack callBack, SPUtils spUtils) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.resolver = mContext.getContentResolver();
        this.spUtils = spUtils;
    }


    public void getInitView() {

        int currentScreenTimeout = Settings.System.getInt(resolver, SCREEN_OFF_TIMEOUT,
                Config.Settings.VALUE_NEVER);
        int shtDownTime = spUtils.getInt(Config.PassWordKey.ONTIME_SHUTDOWN_KEY);

        int autoShtDownTime = spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY);

        if (callBack == null) return;
        callBack.setInitView(currentScreenTimeout, shtDownTime, autoShtDownTime);

    }

    public boolean setScreenTimeout(int screenTimeout) {
        boolean isSuccess = Settings.System.putInt(resolver, SCREEN_OFF_TIMEOUT, screenTimeout);
        LogUtils.e("tlh", "AutoShueDownMode---setScreenTimeout---screenTimeout:" + screenTimeout + ",isSuccess:" + isSuccess);
        return isSuccess;
    }


    @Override
    public void onDestroy() {
        if (mContext != null)
            mContext = null;
        if (resolver != null)
            resolver = null;
        callBack = null;

    }

    public static interface CallBack {

        void setInitView(int screenOffTimeout, int shutDwonTime, int autoShutDwonTime);

    }
}
