package com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.SystemPropertiesUtils;

/**
 * Created by Tianluhua on 2018\7\3 0003.
 */
public class SystemUpdatePresenter extends AbstractPresenter<SystemUpdateView> {


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
}
