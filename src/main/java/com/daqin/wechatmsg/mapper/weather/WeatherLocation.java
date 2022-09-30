package com.daqin.wechatmsg.mapper.weather;

import lombok.Data;

@Data
public class WeatherLocation {
    public String country;
    public String province;
    public String city;
    public String name;
    public String id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
