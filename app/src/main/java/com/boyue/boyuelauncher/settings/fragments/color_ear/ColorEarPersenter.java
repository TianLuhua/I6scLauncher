package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.IdentityHashMap;

import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_OFF;
import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_ON;

public class ColorEarPersenter extends AbstractPresenter<ColorEarView> {

    //    private int colorEarStatus;
    private ColorEarMode earMode;
    private Context mContext;

    public ColorEarPersenter(Context mContext) {
        this.mContext = mContext;
        this.earMode = new ColorEarMode(mContext, new ColorEarMode.CallBack() {
            @Override
            public void colorEarStatus(int isOpen) {

                ColorEarView view = getView();
                if (view == null) return;
                view.setColorEarStatus(isOpen == 1);

            }


        });
    }

    public void getColorEarStatus() {
        if (earMode == null) return;
        earMode.getColorEarStatus();
    }


    public void setColorEarStatus(boolean isOpen) {

        Intent intent = new Intent();
        intent.setAction(isOpen ? COLOR_EAR_OFF : COLOR_EAR_ON);
        mContext.sendBroadcast(intent);
        LogUtils.e("tlh", "setColorEarStatus--action:" + (isOpen ? COLOR_EAR_OFF : COLOR_EAR_ON));

    }
}
