package com.course.demo.Util;


import com.course.demo.Entity.Result;

public class ResultUtil {

    /**
     * 请求成功  没有返回值
     * @return
     */
    public static Result success(){
        return new Result(CodeType.SUCCESS.getCode(),CodeType.SUCCESS.getMsg());
    }

    /**
     * 请求成功  带有返回值
     * @param object 返回值数据
     * @return
     */
    public static Result<Object> success(Object object){
        return new Result(CodeType.SUCCESS.getCode(),CodeType.SUCCESS.getMsg(),object);
    }

    /**
     * 请求错误 默认信息
     * @return
     */
    public static Result error(){
        return new Result(CodeType.ERROR.getCode(),CodeType.ERROR.getMsg());
    }

    /**
     * 请求错误
     * @param msg 自定义错误信息
     * @return
     */
    public static Result error(String msg){
        return new Result(CodeType.ERROR.getCode(),msg);
    }

    /**
     * 不支持该请求
     * @return
     */
    public static Result notSupport(){
        return new Result(CodeType.NOT_SUPPORT.getCode(),CodeType.NOT_SUPPORT.getMsg());
    }

    /**
     * 用户未登录
     * @return
     */
    public static Result notLogin(){
        return new Result(CodeType.NOT_LOGIN.getCode(),CodeType.NOT_LOGIN.getMsg());
    }

    /**
     * 找不到该网页
     * @return
     */
    public static Result notFound(){
        return new Result(CodeType.NOT_FOUND.getCode(),CodeType.NOT_FOUND.getMsg());
    }

    /**
     * 参数错误
     * @return
     */
    public static Result paramError(){
        return new Result(CodeType.PARAM_ERROR.getCode(),CodeType.PARAM_ERROR.getMsg());
    }

    /**
     * 具体参数错误
     */
    public static Result paramError(String msg){
        return new Result(CodeType.PARAM_ERROR.getCode(),CodeType.PARAM_ERROR.getMsg(),msg);
    }

    /**
     * 数据库异常
     * @return
     */
    public static Result databaseError(){
        return new Result(CodeType.DATABASE_ERROR.getCode(),CodeType.DATABASE_ERROR.getMsg());
    }

    /**
     * 数据库异常
     * @param object 异常的位置
     * @return
     */
    public static Result<Object> databaseError(Object object){
        return new Result(CodeType.DATABASE_ERROR.getCode(),CodeType.DATABASE_ERROR.getMsg(),object);
    }

    /**
     * 自定义返回值
     * @param code 状态码
     * @param msg 返回消息
     * @param object 返回值
     * @return
     */
    public static Result<Object> selfResult(Integer code,String msg,Object object){
        return new Result(code,msg,object);
    }

    /**
     * 自定义返回值
     * @param code 状态码
     * @param msg 返回消息
     * @return
     */
    public static Result selfResultNoData(Integer code, String msg){
        return new Result(code,msg);
    }

    /**
     * 未知错误
     * @return
     */
    public static Result unknownError(){
        return new Result(-1,"未知错误");
    }
}
