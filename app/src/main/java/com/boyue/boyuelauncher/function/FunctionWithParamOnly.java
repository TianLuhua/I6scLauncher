package com.boyue.boyuelauncher.function;

/**
 * Created by Tianluhua on 2018/5/11.
 */

public abstract class FunctionWithParamOnly<P> extends Function {

    public FunctionWithParamOnly(String functionName) {
        super(functionName);
    }

    public abstract void function(P p);
}
