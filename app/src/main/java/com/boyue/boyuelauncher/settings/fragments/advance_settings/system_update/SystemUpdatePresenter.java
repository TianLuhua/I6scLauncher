package com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.SystemPropertiesUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;

/**
 * Created by Tianluhua on 2018\7\3 0003.
 */
public class SystemUpdatePresenter extends AbstractPresenter<SystemUpdateView> {


    private SystemUpdateMode mode;

    public SystemUpdatePresenter() {
        this.mode = new SystemUpdateMode(new SystemUpdateMode.CallBack() {
            @Override
            public void setSystemUpdateProgress(int progress) {
                getView().setSystemUpdateProgress(progress);
            }
        });
    }

    public void getCurrentVersion() {
        SystemUpdateView view = getView();
        if (view == null) return;
        view.setCurrentVersion(getFirmwareVersion());
    }

    /**
     * 获取固件版本号
     * <p>
     * ro.build.version.incremental
     *
     * @return
     */
    private String getFirmwareVersion() {
        return SystemPropertiesUtils.getString("ro.build.version.incremental");
    }

    /**
     * 固件包下载完成，立即重启升级
     */
    public void reboot() {
        ToastUtil.showShortToast("立即重启！");
    }

    /**
     * 开始下载固件包
     */
    public void update() {
        if (mode == null) return;
        mode.updateSystem();
    }
}
