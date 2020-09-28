package com.course.demo.Entity;

import lombok.*;

/**
 * @author LvHao
 * @Description : 通用返回类型
 * @date 2020-08-09 10:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Result<T> {

    /**
     * 返回的状态码
     */
    @NonNull
    private Integer code;

    /**
     * 返回的消息
     */
    @NonNull
    private String message;

    /**
     * 返回的数据data
     */
    private T data = null;
}
