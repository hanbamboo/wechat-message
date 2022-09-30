package com.daqin.wechatmsg.mapper.weather;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class WeatherResult {
    public String now_temp;//温度
    public String now_feels_likes;//体感温度
    public String now_rh;//相对湿度
    public String now_wind_class;//风级
    public String now_text;//天气状况
    public String now_wind_dir;//风向
    public String now_uptime;//数据更新时间

    public String location_country;
    public String location_province;
    public String location_city;
    public String location_name;
    public String location_id;


    List<WeatherForcasts> SevenDays;//七日数据

    public WeatherResult() {

    }

    public WeatherResult(WeatherNow weatherNow, WeatherLocation weatherLocation, List<WeatherForcasts> sevenDays) {
        this.now_temp = weatherNow.temp;
        this.now_feels_likes = weatherNow.feels_like;
        this.now_rh = weatherNow.rh;
        this.now_wind_class = weatherNow.wind_class;
        this.now_text = weatherNow.text;
        this.now_wind_dir = weatherNow.wind_dir;
        this.now_uptime = weatherNow.uptime;
        this.location_country = weatherLocation.country;
        this.location_province = weatherLocation.province;
        this.location_city = weatherLocation.city;
        this.location_name = weatherLocation.name;
        this.location_id = weatherLocation.id;
        SevenDays = sevenDays;
    }

    public String getNow_temp() {
        return now_temp;
    }

    public void setNow_temp(String now_temp) {
        this.now_temp = now_temp;
    }

    public String getNow_feels_likes() {
        return now_feels_likes;
    }

    public void setNow_feels_likes(String now_feels_likes) {
        this.now_feels_likes = now_feels_likes;
    }

    public String getNow_rh() {
        return now_rh;
    }

    public void setNow_rh(String now_rh) {
        this.now_rh = now_rh;
    }

    public String getNow_wind_class() {
        return now_wind_class;
    }

    public void setNow_wind_class(String now_wind_class) {
        this.now_wind_class = now_wind_class;
    }

    public String getNow_text() {
        return now_text;
    }

    public void setNow_text(String now_text) {
        this.now_text = now_text;
    }

    public String getNow_wind_dir() {
        return now_wind_dir;
    }

    public void setNow_wind_dir(String now_wind_dir) {
        this.now_wind_dir = now_wind_dir;
    }

    public String getNow_uptime() {
        return now_uptime;
    }

    public void setNow_uptime(String now_uptime) {
        this.now_uptime = now_uptime;
    }

    public String getLocation_country() {
        return location_country;
    }

    public void setLocation_country(String location_country) {
        this.location_country = location_country;
    }

    public String getLocation_province() {
        return location_province;
    }

    public void setLocation_province(String location_province) {
        this.location_province = location_province;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public List<WeatherForcasts> getSevenDays() {
        return SevenDays;
    }

    public void setSevenDays(List<WeatherForcasts> sevenDays) {
        SevenDays = sevenDays;
    }
}
