package com.boyue.boyuelauncher.function;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public abstract class FunctionWithParamNoResult<R> extends Function {

    public FunctionWithParamNoResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function();
}
