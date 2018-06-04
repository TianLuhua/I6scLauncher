package com.boyue.boyuelauncher.cleancache;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.DataCleanManager;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;


/**
 * Created by Tianluhua on 2018/5/14.
 */
public class CleanCacheActivity extends AbstractMVPActivity<CleanCacheView, CleanCachePersenter> implements CleanCacheView {


    private String totalCacheSize;

    private Handler mHandler = new CleanCacheHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_cleancache;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        launcherTheRocket();
    }


    @Override
    protected CleanCachePersenter createPresenter() {
        return new CleanCachePersenter();
    }

    private void launcherTheRocket() {
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                final View rocket = findViewById(R.id.rocket);
                Animation rocketAnimation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.activity_cleancache_rocket);
                rocketAnimation
                        .setAnimationListener(new VisibilityAnimationListener(
                                rocket));
                rocket.startAnimation(rocketAnimation);


            }
        }, 150);
    }

    public class VisibilityAnimationListener implements Animation.AnimationListener {

        private View mVisibilityView;

        public VisibilityAnimationListener(View view) {
            mVisibilityView = view;
        }

        public void setVisibilityView(View view) {
            mVisibilityView = view;
        }

        @Override
        public void onAnimationStart(Animation animation) {
            if (mVisibilityView != null) {
                mVisibilityView.setVisibility(View.VISIBLE);
            }
            mHandler.sendEmptyMessage(Config.HandlerGlod.ACTIVITY_CLEANCACHE_START_CLEANCACHE);

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (mVisibilityView != null) {
                mVisibilityView.setVisibility(View.GONE);
            }
            LogUtils.e("tlh", "onAnimationEnd");
            if (mVisibilityView.getId() == R.id.rocket)
                mHandler.sendEmptyMessage(Config.HandlerGlod.ACTIVITY_CLEANCACHE_END_CLEANCACHE);
            mVisibilityView.clearAnimation();

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 启动清理垃圾动画时，Back键无作用
         */
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return false;
        return super.onKeyDown(keyCode, event);
    }


    private static class CleanCacheHandler extends Handler {

        private WeakReference<Activity> activityWeakReference;

        public CleanCacheHandler(Activity mActivity) {
            activityWeakReference = new WeakReference<>(mActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            CleanCacheActivity activity = (CleanCacheActivity) activityWeakReference.get();
            if (activity == null) return;
            switch (msg.what) {
                case Config.HandlerGlod.ACTIVITY_CLEANCACHE_START_CLEANCACHE:
                    try {
                        activity.totalCacheSize = DataCleanManager.getTotalCacheSize(activity.getApplicationContext());
                        DataCleanManager.clearAllCache(activity.getApplicationContext());
                    } catch (Exception e) {
                        e.printStackTrace();
                        activity.totalCacheSize = "0.0Byte";
                    }

                    break;

                case Config.HandlerGlod.ACTIVITY_CLEANCACHE_END_CLEANCACHE:
                    StringBuilder builder = new StringBuilder();
                    builder.append(activity.getResources().getString(R.string.total_cache));
                    builder.append(activity.totalCacheSize);
                    Toast.makeText(activity.getApplicationContext(), builder.toString(), Toast.LENGTH_SHORT).show();
                    activity.finish();
                    activity.overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                    break;

                default:
                    break;
            }
        }
    }


}
