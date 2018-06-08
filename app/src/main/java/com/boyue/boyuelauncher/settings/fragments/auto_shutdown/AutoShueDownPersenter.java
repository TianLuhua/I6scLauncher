package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.content.Context;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class AutoShueDownPersenter extends AbstractPresenter<AutoShueDownView> {

    private AutoShueDownMode mode;
    private Context mContext;


    public AutoShueDownPersenter(Context mContext) {
        this.mContext = mContext;
        this.mode = new AutoShueDownMode(mContext, new AutoShueDownMode.CallBack() {

            @Override
            public void setCurrentScreenTimeout(int screenOffTimeout) {
                AutoShueDownView view = getView();
                if (view == null) return;
                view.setCurrentScreenTimeout(screenOffTimeout);

            }
        });
    }

    public void getCurrentScreenTimeout() {
        if (mode == null) return;
        mode.getCurrentScreenTimeout();

    }

    public boolean setScreenTimeout(int screenTimeout) {

        return mode.setScreenTimeout(screenTimeout);
    }
}
