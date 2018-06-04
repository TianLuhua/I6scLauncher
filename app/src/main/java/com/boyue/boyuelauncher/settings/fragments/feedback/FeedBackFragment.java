package com.boyue.boyuelauncher.settings.fragments.feedback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.KeyboardUtil;
import com.boyue.boyuelauncher.utils.NetworkUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;

public class FeedBackFragment extends AbstractMVPFragment<FeedBackView, FeedBackPersenter> implements FeedBackView, View.OnClickListener {

    private EditText feedBackText;
    private Button feedCommitBt;
    private RelativeLayout feedCommitRootView;

    public static FeedBackFragment newInstance() {
        return new FeedBackFragment();
    }

    public FeedBackFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_feedback, null, false);
        initView(rootview);
        return rootview;
    }

    private void initView(View rootview) {
        feedBackText = rootview.findViewById(R.id.feedback_commit);
        feedCommitBt = rootview.findViewById(R.id.feedback_commit_bt);
        feedCommitBt.setOnClickListener(this);
        feedCommitRootView = rootview.findViewById(R.id.feedback_commit_root);
        feedCommitRootView.setOnClickListener(this);
    }

    @Override
    protected FeedBackPersenter createPresenter() {
        return new FeedBackPersenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.feedback_commit_bt:
                feedBackCommit();
                break;
            case R.id.feedback_commit_root:
                //点击提交意见框之外的地方，隐藏键盘
                KeyboardUtil.hideSoftInput(getActivity());
                break;
        }


    }

    private void feedBackCommit() {
        if (NetworkUtils.isWifiConnected()) {
            String commtString = feedBackText.getText().toString();
            ToastUtil.showShortToast(getActivity().getApplication(), commtString);
        } else {
            ToastUtil.showShortToast(getActivity().getApplication(), "请检查网络");
        }

    }
}
