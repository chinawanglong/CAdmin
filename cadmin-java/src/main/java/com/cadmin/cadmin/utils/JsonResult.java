package com.cadmin.cadmin.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * json返回信息格式定制
 * @author elliot
 * @date 2020-06-19
 * @param <T>
 */
@Data
@AllArgsConstructor
public class JsonResult<T> implements Serializable {
    private T data;
    private Integer code;
    private String msg;

    /**
     * 没有信息返回，默认code=0，提示信息为操作成功
     */
    public JsonResult(){
        this.code = 0;
        this.msg = "操作成功";
    }

    /**
     * 无数据返回，定制返回码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回，默认code=0，提示信息为操作成功
     * @param data
     */
    public JsonResult(T data){
        this.code = 0;
        this.data = data;
        this.msg = "操作成功";
    }

    /**
     * 有数据返回，定制提示信息
     * @param code
     * @param msg
     * @param data
     */
    public JsonResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
