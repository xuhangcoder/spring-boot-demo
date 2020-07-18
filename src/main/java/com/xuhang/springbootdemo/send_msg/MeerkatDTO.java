package com.xuhang.springbootdemo.send_msg;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据网关请求实体
 *
 * @author dumingcao
 * @date 2019/6/26 17:47
 **/
@Getter
@Setter
@ToString
public class MeerkatDTO {

    private String requestKey;

    /**
     * 发送的工号 可以传递List 但需要以 ，分隔
     */
    private String toStaffId;

    /**
     * 文本消息标题
     */
    private String title;

    /**
     * 文本消息内容
     */
    private String content;

    /**
     * 消息内容跳转的类型0：跳转新声原生App页面，1：跳转到微服务缓存服务，2：跳转至在线微服务，3：跳转CAS登陆的微服务，4：跳转到普通URL地址
     */
    private String jumpType;

    /**
     * 跳转参数
     */
    private String jumpParams;

}
