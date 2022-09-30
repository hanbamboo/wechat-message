package com.daqin.wechatmsg.mapper.weather;

import lombok.Data;


@Data
public class WeatherForcasts {
    private String text_day;
    private String text_night;
    //  最高气温
    private String high;
    //  最低气温
    private String low;
    //  风力"3-4级"
    private String wc_day;
    //  风向"东北风"
    private String wd_day;
    private String wc_night;
    private String wd_night;
    private String date;
    private String week;

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getWc_day() {
        return wc_day;
    }

    public void setWc_day(String wc_day) {
        this.wc_day = wc_day;
    }

    public String getWd_day() {
        return wd_day;
    }

    public void setWd_day(String wd_day) {
        this.wd_day = wd_day;
    }

    public String getWc_night() {
        return wc_night;
    }

    public void setWc_night(String wc_night) {
        this.wc_night = wc_night;
    }

    public String getWd_night() {
        return wd_night;
    }

    public void setWd_night(String wd_night) {
        this.wd_night = wd_night;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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