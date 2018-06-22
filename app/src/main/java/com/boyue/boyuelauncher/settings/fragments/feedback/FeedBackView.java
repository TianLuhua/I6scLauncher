package com.boyue.boyuelauncher.settings.fragments.feedback;

import com.boyue.boyuelauncher.base.BaseView;

public interface FeedBackView extends BaseView {

    //反馈失败
    void onFeedBackFailure();

    //反馈成功
    void onFeedBacksucesess();

}
