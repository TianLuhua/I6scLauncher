package com.boyue.boyuelauncher.widget.dialogfragment;

import com.boyue.boyuelauncher.R;

public class Popup_MacConnectEd_Dialog extends Popup_Only_Icon_Dialog {

    @Override
    protected int getIconRes() {
        return R.mipmap.ic_input_mic;
    }

    @Override
    protected int getLableRes() {
        return R.string.mac_connected;
    }
}
