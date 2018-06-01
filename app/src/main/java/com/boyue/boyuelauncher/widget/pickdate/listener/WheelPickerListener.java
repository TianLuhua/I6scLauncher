package com.boyue.boyuelauncher.widget.pickdate.listener;

import com.boyue.boyuelauncher.widget.pickdate.bean.DateBean;
import com.boyue.boyuelauncher.widget.pickdate.bean.DateType;

/**
 * Created by codbking on 2016/9/22.
 */

public interface WheelPickerListener {
    void onSelect(DateType type, DateBean bean);
}
