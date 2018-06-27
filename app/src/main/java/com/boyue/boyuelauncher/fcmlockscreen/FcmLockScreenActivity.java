package com.boyue.boyuelauncher.fcmlockscreen;

import android.view.KeyEvent;
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
    private TextView weekText;
    private TextView dateText;
    private ImageView number_1, number_2, number_3, number_4;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_fcm_lockscreen;
    }

    @Override
    protected void initView() {
        lockBtn = findViewById(R.id.btn);
        lockBtn.setOnClickListener(this);
        weekText = findViewById(R.id.week);
        dateText = findViewById(R.id.date);
        number_1 = findViewById(R.id.number_1);
        number_2 = findViewById(R.id.number_2);
        number_3 = findViewById(R.id.number_3);
        number_4 = findViewById(R.id.number_4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().cancleLockScreen(Config.BoYueAction.ONTIME_REST_ACTION);
        getPresenter().registerReceiver();
        updateClock();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().unregisterReceiver();
    }

    @Override
    protected FcmLockScreenPersenter createPresenter() {
        return new FcmLockScreenPersenter(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                showPwdDialog();
                break;
        }

    }

    //用于密码验证
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
            public void reSetPassWord() {
                getPresenter().reSetPassWord();

            }

            @Override
            public void hasInputNumbers(String pwd) {
                if (getPresenter().matchingPwd(pwd)) {
                    LogUtils.e("tlh", "通过密码验证，您的密码是：" + pwd);
                    dialog.dismiss();
                    FcmLockScreenActivity.this.finish();
                } else {
                    dialog.setTieltT(R.string.input_pwd_error, R.color.color_red);
                    dialog.cleanPwdStatus();
                }

            }

        });
        dialog.show(getSupportFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
        dialog.setCancelable(false);

    }


    //更新时钟
    private void updateClock() {
        getPresenter().updateClock();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setUpdateClock(String date, String week, int time_0_Leve, int time_1_Leve, int time_2_Leve, int time_3_Leve) {
        LogUtils.e("tlh", "FcmLockScreenActivity--updateClock----date:" + date + ",week：" + week + ",time_0_Leve:" + time_0_Leve + ",time_1_Leve:" + time_1_Leve + ",time_2_Leve:" + time_2_Leve + ",time_3_Leve:" + time_3_Leve);
        dateText.setText(date);
        weekText.setText(week);
        //这里不会有不必要的界面刷新，因为Drawable中有对Level的对比
        number_1.getDrawable().setLevel(time_0_Leve);
        number_2.getDrawable().setLevel(time_1_Leve);
        number_3.getDrawable().setLevel(time_2_Leve);
        number_4.getDrawable().setLevel(time_3_Leve);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().startLockScreen(Config.BoYueAction.ONTIME_REST_ACTION);
    }
}
