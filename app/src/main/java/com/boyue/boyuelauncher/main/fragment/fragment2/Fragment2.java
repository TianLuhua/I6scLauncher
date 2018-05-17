package com.boyue.boyuelauncher.main.fragment.fragment2;

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

public class Fragment2 extends BaseFragment {
    public static final String INTERFACE_RESULT = Fragment2.class.getName() + "WithResault";

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    public Fragment2() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_2, null);
//        Button btn = (Button) view.findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str = null;
//                try {
//                    str = mFunctionManager.invokeFunction(INTERFACE_RESULT, String.class);
//                } catch (FunctionExcepstion functionExcepstion) {
//                    functionExcepstion.printStackTrace();
//                }
//                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
