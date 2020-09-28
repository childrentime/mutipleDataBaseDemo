package com.course.demo.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author LvHao
 * @Description : 返回状态码枚举
 * @date 2020-08-08 22:52
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CodeType {


    /**
     * 服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。
     */
    SUCCESS(200,"成功！"),

    /**
     * 请求错误失败
     */
    ERROR(500,"请求错误！"),

    /**
     * （HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本
     */
    NOT_SUPPORT(505,"不支持访问"),

    /**
     * 未登录
     */
    NOT_LOGIN(401,"用户未登录"),

    /**
     * 找不到请求的资源  数据库中没有
     */
    NOT_FOUND(404,"找不到网页"),

    /**
     * 参数不合法
     */
    PARAM_ERROR(201,"参数不合法"),

    /**
     * 数据库异常
     */
    DATABASE_ERROR(202,"数据库异常");


    private Integer code;
    private String msg;

}
