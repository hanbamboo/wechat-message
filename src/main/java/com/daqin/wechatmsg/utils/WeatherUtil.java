package com.daqin.wechatmsg.utils;

import com.alibaba.fastjson.JSONObject;
import com.daqin.wechatmsg.configure.ApiConfigure;
import com.daqin.wechatmsg.mapper.RequestResult;
import com.daqin.wechatmsg.mapper.weather.WeatherForcasts;
import com.daqin.wechatmsg.mapper.weather.WeatherLocation;
import com.daqin.wechatmsg.mapper.weather.WeatherNow;
import com.daqin.wechatmsg.mapper.weather.WeatherResult;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
public class WeatherUtil {
    //str  2022 09 12 19 45 00
    public static String getUptime(String str) {
        StringBuilder sb = new StringBuilder();
        str = str + "0";
        return sb.append(str, 0, 4).append("-")
                .append(str, 4, 6).append("-")
                .append(str, 6, 8).append(" ")
                .append(str, 8, 10).append(":")
                .append(str, 10, 12).toString();
    }


    public static RequestResult getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("district_id", ApiConfigure.getDistrict_id());
        map.put("ak", ApiConfigure.getAk());
        String res = restTemplate.getForObject("https://api.map.baidu.com/weather/v1/?district_id={district_id}&data_type=all&ak={ak}", String.class, map);
        JSONObject json = JSONObject.parseObject(res);
        RequestResult result = new RequestResult();
        if (json == null) {
            //接口地址有误或者接口没调通
            result.setCode("500");
            result.setMessage("接口不通,请检查接口地址!");
            return result;
        }
//            获取接口响应状态
        String status = json.getString("status");
        if (!"0".equals(status)) {
//            响应状态不为0即调用出错
            String err = json.getString("message");
            result.setCode(status);
            result.setMessage("天气接口调用报错:" + err);
            return result;
        }

//        System.out.println(json);


        ;


        result.setCode(status);
        result.setData(new WeatherResult(
                json.getJSONObject("result")
                        .getJSONObject("now")
                        .toJavaObject(WeatherNow.class),
                json.getJSONObject("result")
                        .getJSONObject("location")
                        .toJavaObject(WeatherLocation.class),
                json.getJSONObject("result")
                        .getJSONArray("forecasts")
                        .toJavaList(WeatherForcasts.class)
        ));
        return result;
    }

    public static RequestResult getWeatherLife() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("location", ApiConfigure.getQweatherLocation());
        map.put("key", ApiConfigure.getQweatherKey());
        map.put("type", ApiConfigure.getQweatherType());


        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName("GBK"));
                break;
            }
        }


//发送请求
        byte[] res = Objects.requireNonNull(restTemplate.getForObject("https://devapi.qweather.com/v7/indices/1d?location={location}&key={key}&type={type}", String.class, map)).getBytes(StandardCharsets.UTF_8);
//        JSONObject json = JSONObject.parseObject(res);

        RequestResult result = new RequestResult();
//        if (json == null) {
//            //接口地址有误或者接口没调通
//            result.setCode("500");
//            result.setMessage("接口不通,请检查接口地址!");
//            return result;
//        }
////            获取接口响应状态
//        String status = json.getString("status");
//        if (!"0".equals(status)) {
////            响应状态不为0即调用出错
//            String err = json.getString("message");
//            result.setCode(status);
//            result.setMessage("生活指数接口调用报错:" + err);
//            return result;
//        }
//
        System.out.println(new String(res));
        result.setCode("200");
        result.setData(res);

        return result;
    }

    public static RequestResult getWeatherToast() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("location", ApiConfigure.getQweatherLocation());
        map.put("key", ApiConfigure.getQweatherKey());

//发送请求
        byte[] s = Objects.requireNonNull(Objects.requireNonNull(restTemplate.getForEntity("https://devapi.qweather.com/v7/warning/now?location={location}&key={key}", String.class, map)).getBody()).getBytes(StandardCharsets.UTF_8);

        //        JSONObject json = JSONObject.parseObject(res);


        RequestResult result = new RequestResult();
//        if (json == null) {
//            //接口地址有误或者接口没调通
//            result.setCode("500");
//            result.setMessage("接口不通,请检查接口地址!");
//            return result;
//        }
////            获取接口响应状态
//        String status = json.getString("status");
//        if (!"0".equals(status)) {
////            响应状态不为0即调用出错
//            String err = json.getString("message");
//            result.setCode(status);
//            result.setMessage("生活指数接口调用报错:" + err);
//            return result;
//        }
//
//        System.out.println(s);
        result.setCode("200");
        result.setData(s);

        return result;
    }
}
