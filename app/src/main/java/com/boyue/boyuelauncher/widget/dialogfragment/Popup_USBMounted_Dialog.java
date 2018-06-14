package com.boyue.boyuelauncher.widget.dialogfragment;

import com.boyue.boyuelauncher.R;

/**
 * U盘挂载
 */
public class Popup_USBMounted_Dialog extends Popup_Only_Icon_Dialog {
    @Override
    protected int getIconRes() {
        return R.mipmap.ic_input_u;
    }

    @Override
    protected int getLableRes() {
        return R.string.usb_mounted;
    }
}
