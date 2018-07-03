package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.IdentityHashMap;

import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_OFF;
import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_ON;
import static com.boyue.boyuelauncher.Config.PassWordKey.DEFAULT_LED_KEY;

public class ColorEarPersenter extends AbstractPresenter<ColorEarView> {


    //    private int colorEarStatus;
    private ColorEarMode earMode;
    private Context mContext;
    private final SPUtils spUtils;

    public ColorEarPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        this.earMode = new ColorEarMode(mContext, new ColorEarMode.CallBack() {
            @Override
            public void colorEarStatus(int isOpen) {

                ColorEarView view = getView();
                if (view == null) return;
                view.setColorEarStatus(isOpen == 1);
            }

        }, spUtils);

    }

    public void getColorEarStatus() {
        if (earMode == null) return;
        earMode.getColorEarStatus();
    }


    public void setColorEarStatus(final boolean isOpen) {

        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setAction(isOpen ? COLOR_EAR_ON : COLOR_EAR_OFF);
                mContext.sendBroadcast(intent);
                LogUtils.e("tlh", "setColorEarStatus--action:" + (isOpen ? COLOR_EAR_ON : COLOR_EAR_OFF));
                spUtils.put(DEFAULT_LED_KEY, isOpen ? 1 : 0);
            }
        });
    }
}
