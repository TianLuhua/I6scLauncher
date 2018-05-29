package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.content.Context;

import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.AbstractPresenter;

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

        if (earMode == null) return;
        earMode.setColorEarStatus(isOpen);
    }
}
