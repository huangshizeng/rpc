package com.huang.rpc.rpc04;

import java.io.Serializable;

public class Info implements Serializable {

    private static final long serialVersionUID = -5296274839945376093L;
    private String method;

    private Class[] parameterTypes;

    private Object[] params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
