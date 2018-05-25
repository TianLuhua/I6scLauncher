package com.boyue.boyuelauncher.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;

/**
 * Created by Tianluhua on 2018/5/14.
 */
public class BatteryView extends AppCompatImageView {

    private boolean isConnected = false;
    private boolean isFull = false;
    private AnimationDrawable animationDrawable;
    //当拔出电源的时候，会收到获取到电量改变和拔出充电器的广播。拔出是总电量和电量等级均为默认值。所有这里保存了，当电量改变时候的总电量和电量等级的比值
    private float currentPrecent;

    private int[] chargeDrawables = new int[]{
            R.mipmap.ic_dc_00,
            R.mipmap.ic_dc_01,
            R.mipmap.ic_dc_02,
            R.mipmap.ic_dc_03,
            R.mipmap.ic_dc_04,
            R.mipmap.ic_dc_05,
    };

    public BatteryView(Context context) {
        super(context);
    }

    public BatteryView(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public BatteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    private BroadcastReceiver mPowerConnectionReceiver = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String acyion = intent.getAction();
                if (TextUtils.isEmpty(acyion)) return;

                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
                float percent = level / (float) scale;

                switch (acyion) {
                    case Intent.ACTION_BATTERY_CHANGED://电量发生改变

                        if (!isConnected)
                            setImageResource(chargeDrawables[(int) (percent * (chargeDrawables.length - 1))]);
                        if (percent == 1) {
                            isFull = true;
                            if (animationDrawable != null)
                                animationDrawable.stop();
                            setImageResource(chargeDrawables[chargeDrawables.length - 1]);
                        } else {
                            isFull = false;
                        }
                        currentPrecent = percent;
                        Toast.makeText(getContext(), "ACTION_BATTERY_CHANGED--->percent：" + percent + ",current:" + level + ",total:" + scale, Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_POWER_CONNECTED://接通电源
                        if (!isFull) {
                            setImageResource(R.drawable.chargeing_animation);
                            animationDrawable = (AnimationDrawable) getDrawable();
                            animationDrawable.start();
                        }
                        isConnected = true;
                        Toast.makeText(getContext(), "ACTION_POWER_CONNECTED", Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED://拔出电源current 和total均为默认值
                        isConnected = false;
                        if (animationDrawable != null)
                            animationDrawable.stop();

                        Toast.makeText(getContext(), "ACTION_POWER_DISCONNECTED--->percent：" + percent + ",current:" + level + ",total:" + scale, Toast.LENGTH_SHORT).show();
                        setImageResource(chargeDrawables[(int) (currentPrecent * (chargeDrawables.length - 1))]);

                }
            }

        }

        ;


    };

    @Override
    protected void onAttachedToWindow() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        getContext().registerReceiver(mPowerConnectionReceiver, intentFilter);
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        getContext().unregisterReceiver(mPowerConnectionReceiver);
        super.onDetachedFromWindow();
    }
}
