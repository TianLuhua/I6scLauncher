package com.boyue.boyuelauncher.widget.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.boyue.boyuelauncher.widget.pickdate.DatePickDialog;
import com.boyue.boyuelauncher.widget.pickdate.OnChangeLisener;
import com.boyue.boyuelauncher.widget.pickdate.OnSureLisener;
import com.boyue.boyuelauncher.widget.pickdate.bean.DateType;

public class Setting_SetDateDialog extends DialogFragment {


    private DateType type;

    private OnChangeLisener onChangeLisener;
    private OnSureLisener onSureLisener;

    private int titleRes;
    private int leftBtnRes;
    private int rightBtnRes;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return showDatePickDialog();
    }


    private Dialog showDatePickDialog() {
        DatePickDialog dialog = new DatePickDialog(getContext());

        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle(titleRes);

        dialog.setLeftBtnString(leftBtnRes);
        dialog.setRightBtnString(rightBtnRes);
        //设置类型
        dialog.setType(type);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(onChangeLisener != null ? onChangeLisener : null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(onSureLisener);
        return dialog;
    }

    public DateType getType() {
        return type;
    }

    public void setType(DateType type) {
        this.type = type;
    }


    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }


    public void setLeftBtnRes(int leftBtnRes) {
        this.leftBtnRes = leftBtnRes;
    }

    public int getRightBtnRes() {
        return rightBtnRes;
    }

    public void setRightBtnRes(int rightBtnRes) {
        this.rightBtnRes = rightBtnRes;
    }

    //设置选择回调
    public void setOnChangeLisener(OnChangeLisener onChangeLisener) {
        this.onChangeLisener = onChangeLisener;
    }

    //设置点击确定按钮，回调
    public void setOnSureLisener(OnSureLisener onSureLisener) {
        this.onSureLisener = onSureLisener;
    }

}
