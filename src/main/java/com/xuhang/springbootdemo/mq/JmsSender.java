package com.xuhang.springbootdemo.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xuhang
 * @date 2019/4/10 14:41
 */
public class JmsSender {
    public static void main(String[] args) throws Exception {
        Session session = null;
        Connection con = null;
        try{
            //通过工厂模式获取链接
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8161");
            con = connectionFactory.createConnection();
            con.start();
            //创建会话（是否使用事务，消息确认机制）
            session = con.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建目的地（消息队列名称）
            Destination destination = session.createQueue("my-queue");
            //创建生产者（消息发送器）
            MessageProducer producer = session.createProducer(destination);
            //发送消息
            for(int i=0;i<3;i++){
                TextMessage message = session.createTextMessage("message--"+i);
                Thread.sleep(1000);
                producer.send(message);
            }
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            con.close();
        }

    }
}
