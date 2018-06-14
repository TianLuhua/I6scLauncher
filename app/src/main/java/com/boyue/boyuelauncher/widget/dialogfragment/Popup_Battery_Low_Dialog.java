package com.boyue.boyuelauncher.widget.dialogfragment;

import com.boyue.boyuelauncher.R;

public class Popup_Battery_Low_Dialog extends Popup_Only_Icon_Dialog {

    @Override
    protected int getIconRes() {
        return R.mipmap.ic_input_battery_low;
    }

    @Override
    protected int getLableRes() {
        return R.string.battery_low;
    }
}
