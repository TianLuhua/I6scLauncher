package com.boyue.boyuelauncher.widget.dialogfragment;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ScreenUtils;

public class Setting_Fcm_Enable_NoteDialog extends Setting_text_01_tutton_03_Dialog {


    @Override
    protected int getTitleRes() {
        return R.string.password_remind;
    }

    @Override
    protected int getMiddleRes() {
        return R.string.know;
    }

    @Override
    protected int getMiddleVisibility() {
        return View.VISIBLE;
    }

    @Override
    protected View getContent() {
        TextView content = new TextView(getContext());
        content.setTextSize(ScreenUtils.dp2px(22));
        content.setTextColor(getResources().getColor(R.color.color_333));
        content.setText(R.string.password_remind_note);
        return content;
    }

    @Override
    protected ViewGroup.LayoutParams getLayoutParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ScreenUtils.dp2px(344), ScreenUtils.dp2px(82));
        params.gravity = Gravity.CENTER;
        return params;
    }

    @Override
    protected int getLeftRes() {
        return 0;
    }

    @Override
    protected int getRightRes() {
        return 0;
    }

}
