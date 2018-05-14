package com.boyue.boyuelauncher.function;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public abstract class FunctionWithParamAndResult<P, R> extends Function {

    public FunctionWithParamAndResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function(P param);
}
