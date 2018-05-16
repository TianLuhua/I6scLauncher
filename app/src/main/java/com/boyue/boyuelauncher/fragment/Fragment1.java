package com.boyue.boyuelauncher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;
import com.boyue.boyuelauncher.function.FunctionExcepstion;
import com.boyue.boyuelauncher.widget.FragmentTilteBar;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class Fragment1 extends BaseFragment {

    public static final String INTERFACE_RESULT = Fragment1.class.getName() + "NPNR";

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_1, null);
        FragmentTilteBar tilteBar = view.findViewById(R.id.title_bar);
        tilteBar.setOnTitleBarClickListener(new FragmentTilteBar.OnTitleBarClickListener() {
            @Override
            public void onBackClick(View view) {
                Toast.makeText(getContext(), "BACK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSettingsClick(View view) {
                Toast.makeText(getContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
            }
        });
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
