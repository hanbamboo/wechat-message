package com.daqin.wechatmsg.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("api")
public class ApiConfigure {
    private static String district_id;

    private static String ak;

    private static String loveDate;

    private static String birthday;

    private static String rainbowKey;
    private static String qweatherKey;
    private static String qweatherLocation;
    private static String qweatherType;

    public static String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        ApiConfigure.district_id = district_id;
    }

    public static String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        ApiConfigure.ak = ak;
    }

    public static String getLoveDate() {
        return loveDate;
    }

    public void setLoveDate(String loveDate) {
        ApiConfigure.loveDate = loveDate;
    }

    public static String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        ApiConfigure.birthday = birthday;
    }

    public static String getRainbowKey() {
        return rainbowKey;
    }

    public void setRainbowKey(String rainbowKey) {
        ApiConfigure.rainbowKey = rainbowKey;
    }

    public static String getQweatherKey() {
        return qweatherKey;
    }

    public void setQweatherKey(String qweatherKey) {
        ApiConfigure.qweatherKey = qweatherKey;
    }

    public static String getQweatherLocation() {
        return qweatherLocation;
    }

    public void setQweatherLocation(String qweatherLocation) {
        ApiConfigure.qweatherLocation = qweatherLocation;
    }

    public static String getQweatherType() {
        return qweatherType;
    }

    public void setQweatherType(String qweatherType) {
        ApiConfigure.qweatherType = qweatherType;
    }


}
