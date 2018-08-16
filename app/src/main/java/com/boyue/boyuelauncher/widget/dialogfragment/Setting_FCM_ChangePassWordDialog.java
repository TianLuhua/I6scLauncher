package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

import static com.boyue.boyuelauncher.Config.PassWordKey.RESET_PASSWORD_CLICK_NUMBER;


/**
 * Created by tianluhua on 2018/6/5.
 */
public class Setting_FCM_ChangePassWordDialog extends DialogFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    //标题
    private TextView title;

    //显示密码输入状态
    private CheckBox pwd_1;
    private CheckBox pwd_2;
    private CheckBox pwd_3;
    private CheckBox pwd_4;

    //键盘数字
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

    //取消、确认按键
    private Button cancle;
    private Button delete;

    //输入了几密码
    private int hasInputNumbers;

    //最终密码
    private StringBuilder pwdBuilder = new StringBuilder();

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

        title = rootView.findViewById(R.id.dialog_title);

        pwd_1 = rootView.findViewById(R.id.pwd_1);
        pwd_2 = rootView.findViewById(R.id.pwd_2);
        pwd_3 = rootView.findViewById(R.id.pwd_3);
        pwd_4 = rootView.findViewById(R.id.pwd_4);
        pwd_1.setOnCheckedChangeListener(this);
        pwd_2.setOnCheckedChangeListener(this);
        pwd_3.setOnCheckedChangeListener(this);
        pwd_4.setOnCheckedChangeListener(this);
        pwd_1.setClickable(false);
        pwd_2.setClickable(false);
        pwd_3.setClickable(false);
        pwd_4.setClickable(false);

        number_0 = rootView.findViewById(R.id.number_0);
        number_0.setOnClickListener(this);
        number_0.setTag(Config.Number.Nuumber_0);

        number_1 = rootView.findViewById(R.id.number_1);
        number_1.setOnClickListener(this);
        number_1.setTag(Config.Number.Nuumber_1);

        number_2 = rootView.findViewById(R.id.number_2);
        number_2.setOnClickListener(this);
        number_2.setTag(Config.Number.Nuumber_2);

        number_3 = rootView.findViewById(R.id.number_3);
        number_3.setOnClickListener(this);
        number_3.setTag(Config.Number.Nuumber_3);

        number_4 = rootView.findViewById(R.id.number_4);
        number_4.setOnClickListener(this);
        number_4.setTag(Config.Number.Nuumber_4);

        number_5 = rootView.findViewById(R.id.number_5);
        number_5.setOnClickListener(this);
        number_5.setTag(Config.Number.Nuumber_5);

        number_6 = rootView.findViewById(R.id.number_6);
        number_6.setOnClickListener(this);
        number_6.setTag(Config.Number.Nuumber_6);

        number_7 = rootView.findViewById(R.id.number_7);
        number_7.setOnClickListener(this);
        number_7.setTag(Config.Number.Nuumber_7);

        number_8 = rootView.findViewById(R.id.number_8);
        number_8.setOnClickListener(this);
        number_8.setTag(Config.Number.Nuumber_8);

        number_9 = rootView.findViewById(R.id.number_9);
        number_9.setOnClickListener(this);
        number_9.setTag(Config.Number.Nuumber_9);

        cancle = rootView.findViewById(R.id.cancle);
        cancle.setOnClickListener(this);
        delete = rootView.findViewById(R.id.delete);
        delete.setOnClickListener(this);
    }


    private int clickDeleteButtonCounter = 0;

    @Override
    public void onClick(View v) {

        if (notfication == null) return;

        switch (v.getId()) {
            case R.id.number_0:
            case R.id.number_1:
            case R.id.number_2:
            case R.id.number_3:
            case R.id.number_4:
            case R.id.number_5:
            case R.id.number_6:
            case R.id.number_7:
            case R.id.number_8:
            case R.id.number_9:
                int inputNumber = (Integer) v.getTag();
                notfication.inputNumber(inputNumber);

                hasInputNumbers++;
                //密码只有四位数
                if (hasInputNumbers > 4) {
                    hasInputNumbers = 4;
                    return;
                }
                //将输入的密码添加到缓存中
                pwdBuilder.append(inputNumber);
                updatePwdStatus(true);

                break;
            case R.id.cancle:
                notfication.cancel();
                break;

            case R.id.delete:
                notfication.delete();

                clickDeleteButtonCounter++;
                if (clickDeleteButtonCounter == RESET_PASSWORD_CLICK_NUMBER) {
                    notfication.reSetPassWord();
                }
                //避免删除pwdBuilder中的密码时候，数组下标溢出
                if (hasInputNumbers <= 0) {
                    return;
                }
                //用户点击了删除按钮，根据当前输入密码的个数删除缓存中的密码
                pwdBuilder.deleteCharAt(hasInputNumbers - 1);

                updatePwdStatus(false);

                hasInputNumbers--;
                if (hasInputNumbers < 0) {
                    hasInputNumbers = 0;
                    return;
                }

                break;
        }

    }

    /**
     * 根据输入密码和撤销的情况，更新密码指示的UI
     *
     * @param isInput 判断是输入还是撤销
     */
    private void updatePwdStatus(boolean isInput) {

        LogUtils.e("tlh", "isInput:" + isInput + ",hasInputNumbers:" + hasInputNumbers);

        switch (hasInputNumbers) {
            case 1:
                //判断是输入还是删除
                if (isInput) {
                    //如果是输入的的话，没有选中就使其选中
                    if (!pwd_1.isChecked())
                        pwd_1.setChecked(true);

                } else {
                    //如果是删除的的话，选中就使其不选中
                    if (pwd_1.isChecked())
                        pwd_1.setChecked(false);
                }
                break;
            case 2:
                if (isInput) {

                    if (!pwd_2.isChecked())
                        pwd_2.setChecked(true);

                } else {
                    if (pwd_2.isChecked())
                        pwd_2.setChecked(false);
                }
                break;
            case 3:
                if (isInput) {

                    if (!pwd_3.isChecked())
                        pwd_3.setChecked(true);

                } else {
                    if (pwd_3.isChecked())
                        pwd_3.setChecked(false);
                }
                break;
            case 4:
                if (isInput) {

                    if (!pwd_4.isChecked())
                        pwd_4.setChecked(true);

                } else {
                    if (pwd_4.isChecked())
                        pwd_4.setChecked(false);
                }
                break;

        }

    }


    public void setTieltT(int titleRes, int colorRes) {
        title.setText(titleRes);
        if (colorRes == 0) {
            title.setTextColor(getResources().getColor(R.color.color_333));
        } else {

            title.setTextColor(getResources().getColor(colorRes));
        }
    }


    /**
     * 清空密码显示的状态
     */
    public void cleanPwdStatus() {
        if (pwd_1.isChecked()) {
            pwd_1.setChecked(false);
        }
        if (pwd_2.isChecked()) {
            pwd_2.setChecked(false);
        }
        if (pwd_3.isChecked()) {
            pwd_3.setChecked(false);
        }
        if (pwd_4.isChecked()) {
            pwd_4.setChecked(false);
        }
        //清空缓存密码
        pwdBuilder.delete(0, hasInputNumbers);
        hasInputNumbers = 0;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (notfication == null) return;

        if (buttonView.getId() == R.id.pwd_4 && isChecked)
            notfication.hasInputNumbers(pwdBuilder.toString());
    }


    private Notfication notfication;

    public void setNotfication(Notfication notfication) {
        this.notfication = notfication;
    }

    public static interface Notfication {

        //回调当前输入的数字
        void inputNumber(int number);

        //回调完整的四位数的密码
        void hasInputNumbers(String pwd);

        //取消功能键的回调
        void cancel();

        //删除功能键的回调
        void delete();

        //重置密码为：0000
        void reSetPassWord();
    }
}
