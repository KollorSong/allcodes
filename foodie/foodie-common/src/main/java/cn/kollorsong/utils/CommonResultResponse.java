package cn.kollorsong.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CommonResultResponse
 * @Author: kollorsong
 * @Description: 统一结果返回：自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 *
 * @DateTime: 2022/7/17 - 9:42 AM
 */
@Data //省略get  set 方法
@Accessors(chain = true) //打开链式操作
public class CommonResultResponse<T>{

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private T data;
    //附加数据，用于扩展
    private Object ext;

    @JsonIgnore
    private String ok;	// 不使用

    public static <E> CommonResultResponse build(Integer status, String msg, E data) {
        return new CommonResultResponse(status, msg, data);
    }

    public static <E> CommonResultResponse build(Integer status, String msg, E data, String ok) {
        return new CommonResultResponse(status, msg, data, ok);
    }
    
    public static <E> CommonResultResponse<E> ok(E data) {
        return new CommonResultResponse<E>(data);
    }


    public static CommonResultResponse ok() {
        return new CommonResultResponse(null);
    }
    
    public static CommonResultResponse errorMsg(String msg) {
        return new CommonResultResponse(500, msg, null);
    }
    
    public static CommonResultResponse errorMap(Object data) {
        return new CommonResultResponse(501, "error", data);
    }
    
    public static CommonResultResponse errorTokenMsg(String msg) {
        return new CommonResultResponse(502, msg, null);
    }
    
    public static CommonResultResponse errorException(String msg) {
        return new CommonResultResponse(555, msg, null);
    }
    
    public static CommonResultResponse errorUserQQ(String msg) {
        return new CommonResultResponse(556, msg, null);
    }

    public CommonResultResponse() {
    }

    public CommonResultResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public CommonResultResponse(Integer status, String msg, T data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public CommonResultResponse(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    //判断请求成功
    public Boolean isOK() {
        return this.status == 200;
    }

}
