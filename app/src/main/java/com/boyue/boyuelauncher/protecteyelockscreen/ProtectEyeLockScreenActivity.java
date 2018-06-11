package com.boyue.boyuelauncher.protecteyelockscreen;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_FCM_ChangePassWordDialog;

public class ProtectEyeLockScreenActivity extends AbstractMVPActivity<ProtectEyeLockScreenView, ProtectEyeLockScreenPersenter> implements ProtectEyeLockScreenView, View.OnClickListener {

    private ImageView unLockBtn;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_protexteye_lockscreen;
    }

    @Override
    protected void initView() {
        unLockBtn = findViewById(R.id.protect_eye_btn);
        unLockBtn.setOnClickListener(this);
        getPresenter().cancleRegularRestAlarm(Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION);

    }

    @Override
    protected ProtectEyeLockScreenPersenter createPresenter() {
        return new ProtectEyeLockScreenPersenter(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.protect_eye_btn:
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
                LogUtils.e("tlh", "ProtectEyeLockScreenActivity----inputNumber:" + number);
            }

            @Override
            public void cancel() {
                dialog.dismiss();
            }

            @Override
            public void delete() {
                LogUtils.e("tlh", "ProtectEyeLockScreenActivity---delete");
            }

            @Override
            public void hasInputNumbers(String pwd) {
                if (getPresenter().matchingPwd(pwd)) {
                    LogUtils.e("tlh", "通过密码验证，您的密码是：" + pwd);
                    dialog.dismiss();
                    getPresenter().startRegularRestAlarm(Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION);
                    ProtectEyeLockScreenActivity.this.finish();

                } else {
                    dialog.setTieltT(R.string.input_pwd_error, R.color.color_red);
                    dialog.cleanPwdStatus();
                }
            }

        });
        dialog.show(getSupportFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
        dialog.setCancelable(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
