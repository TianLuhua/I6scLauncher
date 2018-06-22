package com.boyue.boyuelauncher.settings.fragments.feedback;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.settings.fragments.feedback.entity.ResponseBean;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FeedBackPersenter extends AbstractPresenter<FeedBackView> {

    //反馈内容：不能为空。
    public static final String CONTENT = "content";
    //类别：不能为空。（i6s）
    public static final String CHANNEL = "channel";
    //channel默认值
    public static final String CHANNEL_DEFAULT_VALUE = "i6s";
    //电话：可以为空。
    public static final String PHONE = "phone";

    //响应,数据格式
    public static final String RESPONSE_RET = "ret";
    public static final String RESPONSE_MSG = "msg";


    private OkHttpClient client;


    public FeedBackPersenter() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public void feedBackCommit(final String commtString, final String phoneNumber) {
        //post方式提交的数据
        FormBody formBody = new FormBody.Builder()
                .add(CONTENT, commtString)
                .add(CHANNEL, CHANNEL_DEFAULT_VALUE)
                .build();
        get(Config.BoYueUrl.FEEDBACK_URL, formBody);

    }


    private void get(String url, FormBody body) {
        Request request = new Request.Builder()
                .url(url)//请求的url
                .post(body)//设置请求方式，get()/post()  查看Builder()方法知，在构建时默认设置请求方式为GET
                .build(); //构建一个请求Request对象
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.e("tlh", "onResponse----onFailure:" + e.getMessage());
                getView().onFeedBackFailure();
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 200) {
                    try {
                        String responseJson = response.body().string();
                        Gson gson = new Gson();
                        ResponseBean ss = gson.fromJson(responseJson, ResponseBean.class);
                        getView().onFeedBacksucesess(ss);
                    } catch (IOException e) {
                        e.printStackTrace();
                        getView().onFeedBackFailure();
                    }
                }
            }
        });
    }


}
