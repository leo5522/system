package com.example.exception;

import lombok.Getter;

/**
 * 自定义异常
 * @Author zby
 * @Date 2023/4/21 14:05
 * @Version 1.0
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String code,String msg) {
        super(msg);
        this.code = code;
    }
}
