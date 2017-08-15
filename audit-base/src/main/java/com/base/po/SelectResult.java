package com.base.po;

import com.common.enums.ResponseEnum;

import java.util.List;

/**
 * 封装查询的结果，以json格式返回。
 * Created by admin on 2016/4/21.
 */
public class SelectResult<T> {

    private List<T> list;
    //表示session是否有效，0代表无效，1代表有效
    private int code;
    private String message;
    private int count;

    public SelectResult(){

    }

    public SelectResult(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public SelectResult(ResponseEnum responseEnum, List<T> list){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
