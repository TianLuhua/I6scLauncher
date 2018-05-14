package com.boyue.boyuelauncher.function;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public class FunctionMnanger {

    private static FunctionMnanger instance;

    private HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String, FunctionWithParamAndResult> mFunctionWithParamAndResult;
    private HashMap<String, FunctionWithParamOnly> mFunctionWithParaOnly;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithResultOnly;

    private FunctionMnanger() {
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamAndResult = new HashMap<>();
        mFunctionWithParaOnly = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
    }

    public static synchronized FunctionMnanger getInstance() {

        if (instance == null) {
            instance = new FunctionMnanger();
        }
        return instance;
    }

    public FunctionMnanger addFunction(FunctionNoParamNoResult function) {
        mFunctionNoParamNoResult.put(function.mFunctionName, function);
        return this;
    }

    public void invokeFunction(String functionName) throws FunctionExcepstion {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (mFunctionNoParamNoResult != null) {
            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(functionName);
            if (f != null) {
                f.function();
            } else {
                throw new FunctionExcepstion("Has no this function:" + functionName);
            }
        }
    }

    public FunctionMnanger addFunction(FunctionWithParamAndResult function) {
        mFunctionWithParamAndResult.put(function.mFunctionName, function);
        return this;
    }

    public <R, P> R invokeFunction(String functionName, Class<R> clz, P p) throws FunctionExcepstion {
        if (TextUtils.isEmpty(functionName)) {

            return null;
        }
        if (mFunctionWithParamAndResult != null) {
            FunctionWithParamAndResult f = mFunctionWithParamAndResult.get(functionName);
            if (f != null) {

                if (clz != null) {
                    return clz.cast(f.function(p));

                } else {
                    return (R) f.function(p);

                }

            } else {
                throw new FunctionExcepstion("Has no this function" + functionName);
            }
        }
        return null;
    }

    public FunctionMnanger addFunction(FunctionWithParamOnly function) {
        mFunctionWithParaOnly.put(function.mFunctionName, function);
        return this;
    }

    public <P> void invokeFunction(String functionName, P p) throws FunctionExcepstion {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        if (mFunctionWithParaOnly != null) {

            FunctionWithParamOnly f = mFunctionWithParaOnly.get(functionName);
            if (f != null) {
                f.function(p);
            } else {

                throw new FunctionExcepstion("Has no this function" + functionName);
            }
        }
        return;
    }


    public FunctionMnanger addFunction(FunctionWithResultOnly function) {
        mFunctionWithResultOnly.put(function.mFunctionName, function);
        return this;
    }

    public <R> R invokeFunction(String functionName, Class<R> clz) throws FunctionExcepstion {

        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        if (mFunctionWithResultOnly != null) {
            FunctionWithResultOnly f = mFunctionWithResultOnly.get(functionName);
            if (f != null) {

                if (clz != null) {

                    return clz.cast(f.function());
                } else {
                    return (R) f.function();
                }

            } else {
                throw new FunctionExcepstion("Has no this function" + functionName);
            }

        }
        return null;

    }
}
