package com.cadmin.cadmin.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * json返回信息格式定制
 * @author elliot
 * @date 2020-06-19
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> implements Serializable {
    private T data;
    private Integer code;
    private String msg;


    /**
     * 返回不带数据
     * @return
     */
    public static  JsonResult success(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("操作成功");
        return jsonResult;
    }


    /**
     * 无数据返回，定制返回码和提示信息
     * @param code
     * @param msg
     */
    public static JsonResult success(Integer code, String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return  jsonResult;
    }

    /**
     * 成功返回数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("操作成功");
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 成功返回带数据
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(Integer code, String msg, T data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        jsonResult.setData(data);
        return jsonResult;
    }


    /**
     * 失败 无数据返回
     * @param code
     * @param msg
     * @return
     */
    public static  JsonResult fail(Integer code, String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
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
