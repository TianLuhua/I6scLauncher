package com.boyue.boyuelauncher.fcmlockscreen;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_FCM_ChangePassWordDialog;

public class FcmLockScreenActivity extends AbstractMVPActivity<FcmLockScreenView, FcmLockScreenPersenter> implements FcmLockScreenView, View.OnClickListener {

    private ImageView lockBtn;
    private TextView week;
    private TextView date;


    @Override
    protected int getContentViewID() {
        return R.layout.activity_fcm_lockscreen;
    }

    @Override
    protected void initView() {
        lockBtn = findViewById(R.id.btn);

    }

    @Override
    protected FcmLockScreenPersenter createPresenter() {
        return new FcmLockScreenPersenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                showPwdDialog();
                break;
        }

    }

    private void showPwdDialog() {

        final Setting_FCM_ChangePassWordDialog dialog = new Setting_FCM_ChangePassWordDialog();
        dialog.setCancelable(false);
        dialog.setNotfication(new Setting_FCM_ChangePassWordDialog.Notfication() {
            @Override
            public void inputNumber(int number) {
                LogUtils.e("tlh", "FcmLockScreenActivity----inputNumber:" + number);
            }

            @Override
            public void cancel() {
                dialog.dismiss();
            }

            @Override
            public void delete() {
                LogUtils.e("tlh", "FcmLockScreenActivity---delete");
            }

            @Override
            public void hasInputNumbers(String pwd) {

            }

        });
        dialog.show(getSupportFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
        dialog.setCancelable(false);

    }
}
