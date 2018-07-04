package com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

/**
 * Created by Tianluhua on 2018\7\3 0003.
 */
public class SystemUpdateMode implements BaseMode {

    private CallBack callBack;

    public SystemUpdateMode(CallBack callBack) {
        this.callBack = callBack;
    }


    @Override
    public void onDestroy() {
        if (callBack != null)
            callBack = null;
    }

    public void updateSystem() {
        //模拟下载，返回进度
        ThreadPoolManager.newInstance()
                .addExecuteTask(new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        boolean loop = true;
                        while (loop) {
                            i++;
                            callBack.setSystemUpdateProgress(i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (i == 100) {
                                loop = false;
                            }
                        }
                    }
                });

    }

    public static interface CallBack {

        void setSystemUpdateProgress(int progress);
    }

}
