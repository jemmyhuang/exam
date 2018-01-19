package com.example.exam.constans;

import java.io.Serializable;

public class ModelResult<T> implements Serializable {

    private static final long serialVersionUID = 7247714666080613254L;
    private int success;
    private T data;

    public ModelResult(T data) {
        this.data = data;
        this.success = ResultConstant.SUCCESS;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
