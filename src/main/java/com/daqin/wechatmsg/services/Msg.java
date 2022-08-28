package com.daqin.wechatmsg.services;


import com.daqin.wechatmsg.configure.MsgConfigure;
import com.daqin.wechatmsg.mapper.Result;
import com.daqin.wechatmsg.mapper.Weather;
import com.daqin.wechatmsg.utils.RainbowUtil;
import com.daqin.wechatmsg.utils.WeatherUtil;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;


public class Msg {
    /**
     * 消息推送
     */
    public static String push() {
        // 配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(MsgConfigure.getAppId());
        wxStorage.setSecret(MsgConfigure.getSecret());
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        // 推送消息
        StringBuilder result = new StringBuilder();
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(MsgConfigure.getUserId())
                .templateId(MsgConfigure.getTemplateId())
                .build();


        // 计算天数
//        long loveDays = MemoryDayUtil.calculationLianAi(PushConfigure.getLoveDate());
//        long birthdays = MemoryDayUtil.calculationBirthday(PushConfigure.getBirthday());
//        templateMessage.addData(new WxMpTemplateData("loveDays", loveDays + "", "#FF1493"));
//        templateMessage.addData(new WxMpTemplateData("birthdays", birthdays + "", "#FFA500"));

        // 获取天气数据
        Result weatherResult = WeatherUtil.getWeather();
        StringBuilder messageAll = new StringBuilder();
        if (!"0".equals(weatherResult.getCode())) {
            messageAll.append("<br/>");
            messageAll.append(weatherResult.getMessage());
            templateMessage.addData(new WxMpTemplateData("weather", "***", "#00FFFF"));
        } else {
            Weather weather = (Weather) weatherResult.getData();
            templateMessage.addData(new WxMpTemplateData("date", weather.getDate() + "  " + weather.getWeek(), "#00BFFF"));
            templateMessage.addData(new WxMpTemplateData("weather", weather.getText_now(), "#00FFFF"));
            templateMessage.addData(new WxMpTemplateData("low", weather.getLow() + "", "#173177"));
            templateMessage.addData(new WxMpTemplateData("temp", weather.getTemp() + "", "#EE212D"));
            templateMessage.addData(new WxMpTemplateData("high", weather.getHigh() + "", "#FF6347"));
            templateMessage.addData(new WxMpTemplateData("city", weather.getCity() + "", "#173177"));
        }

        // 天行数据接口
        Result rainbowResult = RainbowUtil.getRainbow();
        if (!"200".equals(rainbowResult.getCode())) {
            messageAll.append("<br/>");
            messageAll.append(rainbowResult.getMessage());
        } else {
            templateMessage.addData(new WxMpTemplateData("rainbow", (String) rainbowResult.getData(), "#FF69B4"));
        }
        // 备注
//        String remark = "❤";
//        if (loveDays % 365 == 0) {
//            remark = "\n今天是恋爱" + (loveDays / 365) + "周年纪念日!";
//        }
//        if (birthdays == 0) {
//            remark = "\n今天是生日,生日快乐呀!";
//        }
//        if (loveDays % 365 == 0 && birthdays == 0) {
//            remark = "\n今天是生日,也是恋爱" + (loveDays / 365) + "周年纪念日!";
//        }
//        templateMessage.addData(new WxMpTemplateData("remark", remark, "#FF1493"));


        System.out.println(templateMessage.toJson());
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            result.append(MsgConfigure.getUserId()).append("推送成功：").append(templateMessage.toJson()).append("\n");
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            result.append(MsgConfigure.getUserId()).append("推送失败：").append(e.getMessage()).append("\n");
        }

        return result.toString();
    }
}
