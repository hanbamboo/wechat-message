package com.daqin.wechatmsg.services;


import com.daqin.wechatmsg.configure.ApiConfigure;
import com.daqin.wechatmsg.mapper.RequestResult;
import com.daqin.wechatmsg.mapper.weather.WeatherForcasts;
import com.daqin.wechatmsg.mapper.weather.WeatherResult;
import com.daqin.wechatmsg.utils.MailUtil;
import com.daqin.wechatmsg.utils.RainbowUtil;
import com.daqin.wechatmsg.utils.WeatherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component

public class Msg {
    @Autowired
    private MailUtil mailUtil;

    /**
     * 消息推送
     */

    public String push() {
//
//
//        // 计算天数
////        long loveDays = MemoryDayUtil.calculationLianAi(PushConfigure.getLoveDate());
////        long birthdays = MemoryDayUtil.calculationBirthday(PushConfigure.getBirthday());
////        templateMessage.addData(new WxMpTemplateData("loveDays", loveDays + "", "#FF1493"));
////        templateMessage.addData(new WxMpTemplateData("birthdays", birthdays + "", "#FFA500"));
//
//        // 获取天气数据
        RequestResult requestResult = WeatherUtil.getWeather();
        StringBuilder messageAll = new StringBuilder();
        WeatherResult weather = new WeatherResult();
        if (!"0".equals(requestResult.getCode())) {
            messageAll.append("<br/>");
            messageAll.append(requestResult.getMessage());
        } else {
            weather = (WeatherResult) requestResult.getData();
        }

        String rainbow = "";
        // 天行数据接口
        RequestResult rainbowResult = RainbowUtil.getRainbow();
        if (!"200".equals(rainbowResult.getCode())) {
            messageAll.append("<br/>");
            messageAll.append(rainbowResult.getMessage());
        } else {
            rainbow = (String) rainbowResult.getData();
        }


//        // 备注
////        String remark = "❤";
////        if (loveDays % 365 == 0) {
////            remark = "\n今天是恋爱" + (loveDays / 365) + "周年纪念日!";
////        }
////        if (birthdays == 0) {
////            remark = "\n今天是生日,生日快乐呀!";
////        }
////        if (loveDays % 365 == 0 && birthdays == 0) {
////            remark = "\n今天是生日,也是恋爱" + (loveDays / 365) + "周年纪念日!";
////        }
////        templateMessage.addData(new WxMpTemplateData("remark", remark, "#FF1493"));
//
//
//        try {
//            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
//            result.append(ApiConfigure.getUserId()).append("推送成功：").append(templateMessage.toJson()).append("\n");
//        } catch (Exception e) {
//            System.out.println("推送失败：" + e.getMessage());
//            result.append(ApiConfigure.getUserId()).append("推送失败：").append(e.getMessage()).append("\n");
//        }

        List<WeatherForcasts> SevenDays = weather.getSevenDays();
        String mailContext = "<div style=\"margin: 0;\n" +
                "\t\t\t\tpadding: 15px;background: linear-gradient(to bottom, rgba(82, 91, 238, .8), rgba(82, 91, 238, .5), rgba(82, 91, 238, .2));\n" +
                "\t\t\t\theight: fit-content;\n" +
                "\t\t\t\tpadding: 20px;\n" +
                "\t\t\t\tborder-radius: 10px;\">\n" +
                "\t\t\t<p style=\"color: #fff;\n" +
                "\t\t\t\tfont-size: 32px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin: 0;\">" + weather.getLocation_city() + " " + weather.location_name + "</p>\n" +
                "\t\t\t<p style=\"color: #fff;\n" +
                "\t\t\t\tfont-size: 32px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin: 0;\">" + SevenDays.get(0).getDate() + "  " + SevenDays.get(0).getWeek() + "</p>\n" +
                "\t\t\t<p style=\"font-size: 18px;color:tomato;font-weight: bold;text-shadow: 0px 0px 2px rgba(0, 0, 0, .5);\">" + rainbow + "</p>\n" +
                "\n" +
                "\t\t\t<div style=\"width: 100%;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tbackground-color: rgb(254, 217, 95);\n" +
                "\t\t\t\tbox-shadow: 0px 3px 20px rgb(254, 217, 95);\">\n" +
                "\n" +
                "\t\t\t\t<h3 style=\" background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tline-height: normal;\n" +
                "\t\t\t\tfont-size: 18px;\">\n" +
                "\t\t\t\t\t现在天气 - 更新时间：" + WeatherUtil.getUptime(weather.now_uptime) + "\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">当前温度：" + weather.now_temp + "°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">体表温度：" + weather.now_feels_likes + "°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">湿度：" + weather.now_rh + "%</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">" + weather.now_text + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">" + weather.now_wind_class + "风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet;\">" + weather.now_wind_dir + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<hr / style=\"margin-top: 20px;\">\n" +
                "\n" +
                "\t\t\t\n" +
                "\t\t\t<div style=\"width: 100%;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tbackground-color: rgb(104, 148, 254);\n" +
                "\t\t\t\tbox-shadow: 0px 3px 20px rgb(104, 148, 254);\">\n" +
                "\t\t\t\t<h3 style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tline-height: normal;\n" +
                "\t\t\t\tfont-size: 18px;\">\n" +
                "\t\t\t\t\t今天天气 - " + SevenDays.get(0).getDate() + " " + SevenDays.get(0).getWeek() + "\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：" + SevenDays.get(0).getHigh() + "°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：" + SevenDays.get(0).getLow() + "°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:" + SevenDays.get(0).getWc_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：" + SevenDays.get(0).getWd_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：" + SevenDays.get(0).getText_day() + "</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:" + SevenDays.get(0).getWc_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：" + SevenDays.get(0).getWd_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：" + SevenDays.get(0).getText_night() + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div style=\"width: 100%;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tbackground-color: rgb(104, 148, 254);\n" +
                "\t\t\t\tbox-shadow: 0px 3px 20px rgb(104, 148, 254);\">\n" +
                "\t\t\t\t<h3 style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tline-height: normal;\n" +
                "\t\t\t\tfont-size: 18px;\">\n" +
                "\t\t\t\t\t明天天气 - " + SevenDays.get(1).getDate() + " " + SevenDays.get(1).getWeek() + "\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：" + SevenDays.get(1).getHigh() + "°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：" + SevenDays.get(1).getLow() + "°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:" + SevenDays.get(1).getWc_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：" + SevenDays.get(1).getWd_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：" + SevenDays.get(1).getText_day() + "</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:" + SevenDays.get(1).getWc_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：" + SevenDays.get(1).getWd_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：" + SevenDays.get(1).getText_night() + "</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div style=\"width: 100%;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tbackground-color: rgb(104, 148, 254);\n" +
                "\t\t\t\tbox-shadow: 0px 3px 20px rgb(104, 148, 254);\">\n" +
                "\t\t\t\t<h3 style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tline-height: normal;\n" +
                "\t\t\t\tfont-size: 18px; \">\n" +
                "\t\t\t\t\t后天天气 - " + SevenDays.get(2).getDate() + " " + SevenDays.get(2).getWeek() + "\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：" + SevenDays.get(2).getHigh() + "°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：" + SevenDays.get(2).getLow() + "°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:" + SevenDays.get(2).getWc_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：" + SevenDays.get(2).getWd_day() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：" + SevenDays.get(2).getText_day() + "</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:" + SevenDays.get(2).getWc_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：" + SevenDays.get(2).getWd_night() + "</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：" + SevenDays.get(2).getText_night() + "</span>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\n" +
                "\t\t</div>";

        
        mailUtil.sendEmail(new String[]{"xxx@qq.com"}, rainbow, mailContext);

        return weather.getNow_uptime()+rainbow+";\n";
    }

}
