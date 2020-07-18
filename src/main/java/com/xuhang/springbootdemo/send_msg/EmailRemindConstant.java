package com.xuhang.springbootdemo.send_msg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * demoDesc
 *
 * @author Caoduming
 * @date 2018/8/21 9:26
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "email")
public class EmailRemindConstant {

    private String sendAccount;

    private String  sendPassword;

    private String protocol;

    private String sendSmtpHost;

    private String smtpPort;

    private Boolean authFlag;

    private String toAccount;

}
