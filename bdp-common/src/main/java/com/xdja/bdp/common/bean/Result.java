package com.xdja.bdp.common.bean;

import lombok.Data;

import static com.xdja.bdp.common.constant.Const.FAIL;
import static com.xdja.bdp.common.constant.Const.SUCCESS;


/**
 * Response Bean
 *
 * @author yxb
 * @since 2019/3/1 1:14
 */
@Data
public class Result<T> {

    /**
     * 成功标识 1成功 0失败
     */
    private String code;

    /**
     * 返回结果信息
     */
    protected String message;

    /**
     * 结果数据
     */
    private T data;

    /**
     * 分页信息
     */
    private PageBean page;

    protected Result() {
    }


    public static <T> Result<T> failResult() {
        return failResult(FAIL, null);
    }

    public static <T> Result<T> failResult(String message) {
        return failResult(message, null);
    }

    public static <T> Result<T> failResult(String message, T data) {
        return create(FAIL, message, data, null);
    }

    public static <T> Result<T> successResult() {
        return successResult(null, null);
    }

    public static <T> Result<T> successResult(T data) {
        return successResult(data, null);
    }

    public static <T> Result<T> successResult(T data, PageBean pageBean) {
        return successResult(null, data, pageBean);
    }

    public static <T> Result<T> successResult(String message, T data, PageBean pageBean) {
        return create(SUCCESS, message, data, pageBean);
    }

    public static <T> Result<T> create(String code, String message, T data, PageBean pageBean) {
        Result<T> Result = new Result<>();
        Result.setCode(code);
        Result.setMessage(message);
        Result.setData(data);
        Result.setPage(pageBean);
        return Result;
    }
}
