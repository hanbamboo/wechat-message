package com.daqin.wechatmsg.controller;

import com.daqin.wechatmsg.services.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRun {
    @RequestMapping("test")
    public String Test(){
        return Msg.push();
    }
}
