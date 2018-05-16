package com.boyue.boyuelauncher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;
import com.boyue.boyuelauncher.function.FunctionExcepstion;


/**
 * Created by Tianluhua on 2018/4/3.
 */

public class Fragment3 extends BaseFragment {
    public static final String INTERFACE_RESULT = Fragment3.class.getName() + "PR";


    public static Fragment3 newInstance() {
        return new Fragment3();
    }

    public Fragment3() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_3,null);
        Button  btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = null;
                try {
                    str = mFunctionManager.invokeFunction(INTERFACE_RESULT,String.class,"这是我自定义的字符串");
                } catch (FunctionExcepstion functionExcepstion) {
                    functionExcepstion.printStackTrace();
                }
                Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
