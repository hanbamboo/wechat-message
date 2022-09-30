package com.daqin.wechatmsg.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;


@Component

public class MailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.nickname}")
    private String nickname;

    int errorResend = 0;
    String[] tos;
    String subjects;
    String contexts;

    public void sendEmail(String[] to, String subject, String context) {
        try {
            tos = to;
            subjects = subject;
            contexts = context;
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(nickname + '<' + from + '>');
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(context, true);
            javaMailSender.send(mimeMessage);
            System.out.println("发送成功" + errorResend);
            errorResend = 0;
        } catch (Exception e) {
            e.printStackTrace();
            errorResend++;
            if (errorResend < 3) {
                System.out.println("重试" + errorResend);
                sendEmail(tos, subjects, contexts);
            }
        }
    }


}

