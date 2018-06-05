package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.boyue.boyuelauncher.R;


/**
 * Created by tianluhua on 2018/6/5.
 */
public class Setting_FCM_ChangePassWordDialog extends DialogFragment implements View.OnClickListener {

    private CheckBox pwd_1;
    private CheckBox pwd_2;
    private CheckBox pwd_3;
    private CheckBox pwd_4;

    private Button number_0;
    private Button number_1;
    private Button number_2;
    private Button number_3;
    private Button number_4;
    private Button number_5;
    private Button number_6;
    private Button number_7;
    private Button number_8;
    private Button number_9;

    private Button cancle;
    private Button delete;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_settings_fcm_change_password, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        pwd_1 = rootView.findViewById(R.id.pwd_1);
        pwd_2 = rootView.findViewById(R.id.pwd_2);
        pwd_3 = rootView.findViewById(R.id.pwd_3);
        pwd_4 = rootView.findViewById(R.id.pwd_4);

        number_0 = rootView.findViewById(R.id.number_0);
        number_1 = rootView.findViewById(R.id.number_1);
        number_2 = rootView.findViewById(R.id.number_2);
        number_3 = rootView.findViewById(R.id.number_3);
        number_4 = rootView.findViewById(R.id.number_4);
        number_5 = rootView.findViewById(R.id.number_5);
        number_6 = rootView.findViewById(R.id.number_6);
        number_7 = rootView.findViewById(R.id.number_7);
        number_8 = rootView.findViewById(R.id.number_8);
        number_9 = rootView.findViewById(R.id.number_9);

        cancle = rootView.findViewById(R.id.cancle);
        delete = rootView.findViewById(R.id.delete);
    }

    @Override
    public void onClick(View v) {


    }




}
