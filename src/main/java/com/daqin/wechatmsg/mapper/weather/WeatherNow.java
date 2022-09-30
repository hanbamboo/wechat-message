package com.daqin.wechatmsg.mapper.weather;

import lombok.Data;

@Data
public class WeatherNow {
    public String temp;
    public String rh;
    public String wind_class;
    public String text;
    public String wind_dir;
    public String feels_like;
    public String uptime;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getWind_class() {
        return wind_class;
    }

    public void setWind_class(String wind_class) {
        this.wind_class = wind_class;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}

/*
{
    "result":{
        "now":{
            "temp":25,
            "rh":60,
            "wind_class":"1级",
            "text":"阴",
            "wind_dir":"东北风",
            "feels_like":26,
            "uptime":"20220903151500"
        },
        "location":{
            "country":"中国",
            "province":"山东省",
            "city":"聊城市",
            "name":"阳谷",
            "id":"371521"
        },
        "forecasts":[
            {
                "wd_night":"北风",
                "date":"2022-09-03",
                "high":27,
                "week":"星期六",
                "text_night":"阴",
                "wd_day":"北风",
                "low":20,
                "wc_night":"<3级",
                "text_day":"阴",
                "wc_day":"<3级"
            },
            {
                "wd_night":"南风",
                "date":"2022-09-04",
                "high":29,
                "week":"星期日",
                "text_night":"阴",
                "wd_day":"南风",
                "low":18,
                "wc_night":"3~4级",
                "text_day":"多云",
                "wc_day":"<3级"
            },
            {
                "wd_night":"南风",
                "date":"2022-09-05",
                "high":27,
                "week":"星期一",
                "text_night":"晴",
                "wd_day":"北风",
                "low":15,
                "wc_night":"<3级",
                "text_day":"晴",
                "wc_day":"3~4级"
            },
            {
                "wd_night":"南风",
                "date":"2022-09-06",
                "high":31,
                "week":"星期二",
                "text_night":"多云",
                "wd_day":"南风",
                "low":17,
                "wc_night":"<3级",
                "text_day":"晴",
                "wc_day":"<3级"
            },
            {
                "wd_night":"南风",
                "date":"2022-09-07",
                "high":30,
                "week":"星期三",
                "text_night":"阴",
                "wd_day":"南风",
                "low":21,
                "wc_night":"<3级",
                "text_day":"多云",
                "wc_day":"<3级"
            }
        ]
    },
    "message":"success",
    "status":0
}
 */
