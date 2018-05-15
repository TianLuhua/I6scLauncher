package com.boyue.boyuelauncher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;
import com.boyue.boyuelauncher.function.FunctionExcepstion;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class Fragment1 extends BaseFragment {

    public static final String INTERFACE_RESULT = Fragment1.class.getName() + "NPNR";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_1, null);
        Button btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mFunctionManager.invokeFunction(INTERFACE_RESULT);
                } catch (FunctionExcepstion functionExcepstion) {
                    functionExcepstion.printStackTrace();
                }
            }
        });
        return view;
    }
}
