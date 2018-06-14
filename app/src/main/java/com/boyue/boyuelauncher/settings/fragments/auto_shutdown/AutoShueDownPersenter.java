package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.content.Context;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
import com.boyue.boyuelauncher.utils.SPUtils;


public class AutoShueDownPersenter extends AbstractPresenter<AutoShueDownView> {

    private AutoShueDownMode mode;
    private Context mContext;
    private SPUtils spUtils;
    private int shutDownTime;


    public AutoShueDownPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        this.mode = new AutoShueDownMode(mContext, new AutoShueDownMode.CallBack() {


            @Override
            public void setInitView(int screenOffTimeout, int shutDwonTime) {
                AutoShueDownView view = getView();
                if (view == null) return;
                view.setInitView(screenOffTimeout, shutDwonTime);
            }
        }, spUtils);
    }

    public void getInitView() {
        if (mode == null) return;
        mode.getInitView();

    }


    public boolean setScreenTimeout(int screenTimeout) {

        return mode.setScreenTimeout(screenTimeout);
    }

    /**
     * 保存定时关机的时间
     *
     * @param time
     */
    public void setShutDownTime(int time) {
        if (spUtils == null) return;
        spUtils.put(Config.PassWordKey.ONTIME_SHUTDOWN_KEY, time);
        this.shutDownTime = time;
    }


    /**
     * 设置是否开启定时关机的任务
     *
     * @param start
     */
    public void startShutDownTask(boolean start) {
        if (start) {
            LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_SHUTDOWN_ACTION, shutDownTime);
        } else {
            LockScreenUtils.cancleLockScreen(Config.BoYueAction.ONTIME_SHUTDOWN_ACTION);
        }

    }
}
