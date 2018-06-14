package com.boyue.boyuelauncher.widget.dialogfragment;

import com.boyue.boyuelauncher.R;

/**
 * USB连接
 */
public class Popup_USBConnected_Dialog extends Popup_Only_Icon_Dialog {
    @Override
    protected int getIconRes() {
        return R.mipmap.ic_input_usb;
    }

    @Override
    protected int getLableRes() {
        return R.string.usb_connected;
    }
}
