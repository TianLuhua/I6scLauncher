package com.boyue.boyuelauncher.player;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.List;

public class SWFPlayerActivity extends Activity {

    private WebView mWebView;
    String mFlashFilename;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swf_player);
        mWebView = findViewById(R.id.flashwebview);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);

        Intent intent = getIntent();
        String str = intent.getStringExtra("flashName");

        if (str == null)
            mFlashFilename = new String("file:///android_asset/kaka.swf");
        else
            mFlashFilename = str;

        try {
            Thread.sleep(500);// 主线程暂停下，否则容易白屏，原因未知
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
                System.out.println("newProgress:"+String.valueOf(newProgress));

            }
        });
        LogUtils.e("tlh","SWFPlayerActivity----mFlashFilename:"+mFlashFilename);

        mWebView.loadUrl(mFlashFilename);
    }


    //检查机子是否安装的有Adobe Flash相关APK
    private boolean checkinstallornotadobeflashapk() {
        PackageManager pm = getPackageManager();
        List<PackageInfo> infoList = pm
                .getInstalledPackages(PackageManager.GET_SERVICES);
        for (PackageInfo info : infoList) {
            if ("com.adobe.flashplayer".equals(info.packageName)) {
                return true;
            }
        }
        return false;
    }

    //安装Adobe Flash APK
    private void installadobeapk() {
        mWebView.addJavascriptInterface(new AndroidBridge(), "android");
        mWebView.loadUrl("file:///android_asset/go_market.html");
    }

    private class AndroidBridge {
        public void goMarket() {
            mHandler.post(new Runnable() {
                public void run() {
                    Intent installIntent = new Intent(
                            "android.intent.action.VIEW");
                    installIntent.setData(Uri.parse("market://details?id=com.adobe.flashplayer"));
                    startActivity(installIntent);
                }
            });
        }
    }
}
