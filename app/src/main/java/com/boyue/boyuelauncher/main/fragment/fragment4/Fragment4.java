package com.boyue.boyuelauncher.main.fragment.fragment4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;


/**
 * Created by Tianluhua on 2018/4/3.
 */

public class Fragment4 extends BaseFragment {
    public static final String INTERFACE_RESULT = Fragment4.class.getName() + "NR";

    public static Fragment4 newInstance() {
        return new Fragment4();
    }

    public Fragment4() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_4, null);
//        Button btn = (Button) view.findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                try {
//                    mFunctionManager.invokeFunction(INTERFACE_RESULT, "这是我自定义的字符串");
//                } catch (FunctionExcepstion functionExcepstion) {
//                    functionExcepstion.printStackTrace();
//                }
//
//            }
//        });
        return view;
    }
}
