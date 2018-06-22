package com.boyue.boyuelauncher.settings.fragments.feedback;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.settings.fragments.feedback.entity.ResponseBean;

public interface FeedBackView extends BaseView {

    //反馈失败
    void onFeedBackFailure();

    //反馈成功
    void onFeedBacksucesess(ResponseBean ss);

}
