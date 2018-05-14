package com.boyue.boyuelauncher.function;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public abstract class FunctionWithResultOnly<R> extends Function {
    public FunctionWithResultOnly(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function();

}
