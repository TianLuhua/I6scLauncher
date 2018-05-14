package com.boyue.boyuelauncher.base;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.MainActivity;
import com.boyue.boyuelauncher.function.FunctionMnanger;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public class BaseFragment extends Fragment {

    protected FunctionMnanger mFunctionManager;
    protected MainActivity mBaseActivity;


    public void setmFunctionManager(FunctionMnanger mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFunctionsForFragment(getTag());
        }
    }
}
