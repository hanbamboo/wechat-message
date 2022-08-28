package com.daqin.wechatmsg.scheduled;

import com.daqin.wechatmsg.services.Msg;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@Configuration
public class AutoTask {
//    cron表达式 百度一大片
    @Scheduled(cron = "0 0 7 * * ?")
    public void goodMorning() {
        Msg.push();
    }
}
