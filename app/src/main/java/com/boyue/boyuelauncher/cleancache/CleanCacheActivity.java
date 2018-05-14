package com.boyue.boyuelauncher.cleancache;

import android.os.Handler;
import android.os.Message;
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


/**
 * Created by Tianluhua on 2018/5/14.
 */
public class CleanCacheActivity extends AbstractMVPActivity<CleanCacheView, CleanCachePersenter> implements CleanCacheView {

    private String totalCacheSize ;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case Config.HandlerGlod.ACTIVITY_CLEANCACHE_START_CLEANCACHE:
//                    Toast.makeText(CleanCacheActivity.this, "CleanCache start", Toast.LENGTH_SHORT).show();
                    try {
                        totalCacheSize= DataCleanManager.getTotalCacheSize(getApplicationContext());
                        DataCleanManager.clearAllCache(getApplicationContext());
                    } catch (Exception e) {
                        e.printStackTrace();
                        totalCacheSize="0.0Byte";
                    }

                    break;

                case Config.HandlerGlod.ACTIVITY_CLEANCACHE_END_CLEANCACHE:
                    Toast.makeText(CleanCacheActivity.this, "共清理掉垃圾:"+totalCacheSize, Toast.LENGTH_SHORT).show();
                    finish();
                    overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);


                    break;


                default:
                    break;
            }

        }
    };


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

                final View cloud = findViewById(R.id.cloud);
                Animation cloudAnimation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.activity_cleancache_cloud);
                cloudAnimation
                        .setAnimationListener(new VisibilityAnimationListener(
                                cloud));
                cloud.startAnimation(cloudAnimation);

                final View launcher = findViewById(R.id.launcher);
                Animation launcherAnimation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.activity_cleancache_launcher);
                launcherAnimation
                        .setAnimationListener(new VisibilityAnimationListener(
                                launcher));
                launcher.startAnimation(launcherAnimation);

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
            if (mVisibilityView.getId() == R.id.cloud)
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

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

}
