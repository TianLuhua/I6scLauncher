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
                Log.e("zhang", "acyion: " + acyion);

                switch (acyion) {
                    case Intent.ACTION_BATTERY_CHANGED://电量发生改变
                        int current = intent.getIntExtra("level", -1);//获得当前电量
                        int total = intent.getIntExtra("scale", -1);//获得总电量
                        float percent = current / (float) total;
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
                        /*if (drawable != null)
                            drawable.setLevel(percent);*/
                        Toast.makeText(getContext(), "ACTION_BATTERY_CHANGED", Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_POWER_CONNECTED://接通电源
                        Log.e("zhang", "BatteryBroadcastReceiver --> onReceive--> ACTION_POWER_CONNECTED");
                        if (!isFull) {
                            setImageResource(R.drawable.chargeing_animation);
                            animationDrawable = (AnimationDrawable) getDrawable();
                            animationDrawable.start();
                        }
                        isConnected = true;
                        Toast.makeText(getContext(), "ACTION_POWER_CONNECTED", Toast.LENGTH_SHORT).show();
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED://拔出电源
                        isConnected = false;
                        if (animationDrawable != null)
                            animationDrawable.stop();
                        Log.e("zhang", "BatteryBroadcastReceiver --> onReceive--> ACTION_POWER_DISCONNECTED");
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
