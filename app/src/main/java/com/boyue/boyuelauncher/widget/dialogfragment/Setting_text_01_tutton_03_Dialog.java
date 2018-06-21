package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;

public abstract class Setting_text_01_tutton_03_Dialog extends DialogFragment implements View.OnClickListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootVire = inflater.inflate(R.layout.dialog_settings_text_01_buttom_02, null, false);
        initView(rootVire);
        return rootVire;
    }

    private void initView(View rootVire) {
        TextView title = rootVire.findViewById(R.id.dialog_title);
        title.setText(getTitleRes());
        FrameLayout content = rootVire.findViewById(R.id.dialog_content);
        content.addView(getContent(), getLayoutParams());

        Button left_button = rootVire.findViewById(R.id.dialog_left);
        Button middle_button = rootVire.findViewById(R.id.dialog_middle);
        Button right_button = rootVire.findViewById(R.id.dialog_right);

        int isMiddleVisible = getMiddleVisibility();


        if (isMiddleVisible == View.VISIBLE) {

            middle_button.setVisibility(getMiddleVisibility());
            middle_button.setText(getMiddleRes());
            middle_button.setOnClickListener(this);
            left_button.setVisibility(View.INVISIBLE);
            right_button.setVisibility(View.INVISIBLE);


        } else {

            middle_button.setVisibility(View.INVISIBLE);

            left_button.setText(getLeftRes());
            left_button.setOnClickListener(this);

            right_button.setText(getRightRes());
            right_button.setOnClickListener(this);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_left:
                if (onclickListener == null) return;
                onclickListener.onLeftClick(v);
                break;
            case R.id.dialog_right:
                if (onclickListener == null) return;
                onclickListener.onRightClick(v);
                break;
            case R.id.dialog_middle:
                if (onclickListener == null) return;
                onclickListener.onMiddleClick(v);
                break;
        }

    }


    protected abstract int getTitleRes();

    protected abstract int getMiddleRes();

    protected abstract int getMiddleVisibility();

    protected abstract View getContent();

    protected abstract ViewGroup.LayoutParams getLayoutParams();

    protected abstract int getLeftRes();

    protected abstract int getRightRes();


    private OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    public interface OnclickListener {

        void onLeftClick(View v);

        void onMiddleClick(View v);

        void onRightClick(View v);

    }

}
