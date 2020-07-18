package com.xuhang.springbootdemo.send_msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Session;
import java.util.Properties;

/**
 * demoDesc
 *
 * @author Caoduming
 * @date 2018/8/20 16:38
 */
@Configuration
@Slf4j
public class EmailConfig {


    @Autowired
    private EmailRemindConstant emailRemindConstant;

    /**
     * 使用的协议（JavaMail规范要求）
     */
    private static final String MAIL_PROTOCOL = "mail.transport.protocol";

    /**
     * 发件人的邮箱的 SMTP 服务器地址
     */
    private static final String MAIL_STMP_HOST = "mail.smtp.host";

    /**
     * 需要请求认证
     */
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    /**
     * SMTP连接需要安全认证的话，配置如下属性
     */
    private static final String MAIL_SMTP_PORT = "mail.smtp.port";
    private static final String MAIL_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
    private static final String MAIL_SMTP_SOCKETFACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    private static final String MAIL_SMTP_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";

    @Bean(name = "mailSession")
    public Session getSession(){
        // 参数配置
        Properties properties = new Properties();
        properties.setProperty(MAIL_PROTOCOL, emailRemindConstant.getProtocol());
        properties.setProperty(MAIL_STMP_HOST, emailRemindConstant.getSendSmtpHost());
        properties.setProperty(MAIL_SMTP_AUTH, emailRemindConstant.getAuthFlag().toString());


        /**
         * 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
         * 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
         * 将认证设置为true，同时SMTP 服务器的端口参考以下内容：(非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,需要改为对应邮箱的 SMTP 服务器的端口,
         *                                                     具体可查看对应邮箱服务的帮助,QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
         */
        if (emailRemindConstant.getAuthFlag()) {
            //SSS安全认证需要
            properties.setProperty(MAIL_SMTP_PORT, emailRemindConstant.getSmtpPort());
            properties.setProperty(MAIL_SMTP_SOCKETFACTORY_CLASS, "javax.net.ssl.SSLSocketFactory");
            properties.setProperty(MAIL_SMTP_SOCKETFACTORY_FALLBACK, "false");
            properties.setProperty(MAIL_SMTP_SOCKETFACTORY_PORT, emailRemindConstant.getSmtpPort());
        }


        Session session = Session.getInstance(properties);
        session.setDebug(true);

        return session;
    }
}
