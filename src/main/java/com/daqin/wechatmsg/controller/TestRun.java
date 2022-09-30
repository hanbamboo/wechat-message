package com.daqin.wechatmsg.controller;

import com.daqin.wechatmsg.services.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRun {
    @Autowired
    private Msg msg;

    @RequestMapping("test")
    public String Test() {

        return msg.push();
    }
}
