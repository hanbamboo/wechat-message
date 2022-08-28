package com.daqin.wechatmsg.mapper;

import lombok.Data;


@Data
public class Result {
    private String code;
    private String message;
    private Object data;
}
