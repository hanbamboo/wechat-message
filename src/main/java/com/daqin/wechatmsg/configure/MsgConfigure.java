package com.daqin.wechatmsg.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("msg")
public class MsgConfigure {
    /**
     * 微信公众平台的appID
     */
    private static String appId;
    /**
     * 微信公众平台的appSecret
     */
    private static String secret;
    /**
     * 天气查询的城市ID
     */
    private static String district_id;
    /**
     * 应用AK
     */
    private static String ak;
    /**
     * 提示的纪念日
     */
    private static String loveDate;
    /**
     * 提示的生日
     */
    private static String birthday;
    /**
     * 要发送的用户ID
     */
    private static String userId;
    /**
     * 模板ID
     */
    private static String templateId;

    /**
     * 天行数据apiKey
     */
    private static String rainbowKey;

    public static String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        MsgConfigure.appId = appId;
    }

    public static String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        MsgConfigure.secret = secret;
    }

    public static String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        MsgConfigure.district_id = district_id;
    }

    public static String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        MsgConfigure.ak = ak;
    }

    public static String getLoveDate() {
        return loveDate;
    }

    public void setLoveDate(String loveDate) {
        MsgConfigure.loveDate = loveDate;
    }

    public static String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        MsgConfigure.birthday = birthday;
    }

    public static String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        MsgConfigure.userId = userId;
    }

    public static String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        MsgConfigure.templateId = templateId;
    }

    public static String getRainbowKey() {
        return rainbowKey;
    }

    public void setRainbowKey(String rainbowKey) {
        MsgConfigure.rainbowKey = rainbowKey;
    }
}
