package com.daqin.wechatmsg;

import com.daqin.wechatmsg.utils.MailUtil;
import com.daqin.wechatmsg.utils.WeatherUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WechatMsgApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void weatherTest() {
        System.out.println(WeatherUtil.getWeather().toString());
    }

    @Test
    void weatherLifeTest() {
        WeatherUtil.getWeatherLife();

    }

    @Test
    void weatherLifeToast() {
        WeatherUtil.getWeatherToast();

    }

    @Autowired
    private MailUtil mailUtil;

    @Test
    void mailTest() {
        String mailContext = "<div style=\"margin: 0;\n" +
                "\t\t\t\tpadding: 15px;background: linear-gradient(to bottom, rgba(82, 91, 238, .8), rgba(82, 91, 238, .5), rgba(82, 91, 238, .2));\n" +
                "\t\t\t\theight: fit-content;\n" +
                "\t\t\t\tpadding: 20px;\n" +
                "\t\t\t\tborder-radius: 10px;\">\n" +
                "\t\t\t<p style=\"color: #fff;\n" +
                "\t\t\t\tfont-size: 32px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin: 0;\">地点 地点名</p>\n" +
                "\t\t\t<p style=\"color: #fff;\n" +
                "\t\t\t\tfont-size: 32px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin: 0;\">时间 - 星期八</p>\n" +
                "\t\t\t<p style=\"font-size: 18px;color:tomato;font-weight: bold;text-shadow: 0px 0px 2px rgba(0, 0, 0, .5);\">彩虹屁</p>\n" +
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
                "\t\t\t\t\t现在天气 - 更新时间：XXXXXXXxXXXXX\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">当前温度：99°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">体表温度：99°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">湿度：99%</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">阴</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">99级风</span>\n" +
                "\t\t\t\t<span>东南风</span>\n" +
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
                "\t\t\t\t\t今天天气 - XXXXXXXxXXXXX\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：99°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：-99°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：晴天</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：晴天</span>\n" +
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
                "\t\t\t\t\t明天天气 - XXXXXXXxXXXXX\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：99°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：-99°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：晴天</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：晴天</span>\n" +
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
                "\t\t\t\t\t后天天气 - XXXXXXXxXXXXX\n" +
                "\t\t\t\t</h3>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: rgb(240, 73, 75);\">最高温度：99°</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color: blue;\">最低温度：-99°</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">白间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">白间状况：晴天</span>\n" +
                "\t\t\t\t<br />\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:rgb(61,97,156);\">夜间风级:99</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间风向：东南风</span>\n" +
                "\t\t\t\t<span style=\"background-color: #fff;\n" +
                "\t\t\t\tborder-radius: 10px;\n" +
                "\t\t\t\tpadding: 10px;\n" +
                "\t\t\t\tfont-weight: bold;\n" +
                "\t\t\t\tmargin-left: 10px;\n" +
                "\t\t\t\tmargin-bottom: 10px;\n" +
                "\t\t\t\tdisplay: inline-block;color:blueviolet\">夜间状况：晴天</span>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\n" +
                "\t\t</div>";
        mailUtil.sendEmail(new String[]{"1203423491@qq.com"}, "测试", mailContext);
    }

}
