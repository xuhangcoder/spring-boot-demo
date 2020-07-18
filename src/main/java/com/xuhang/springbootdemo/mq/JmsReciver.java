package com.xuhang.springbootdemo.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author xuhang
 * @date 2019/4/10 14:47
 */
public class JmsReciver {
    public static void main(String args[]) throws Exception{
        Session session = null;
        Connection con = null;
        try{
            //通过工厂模式获取链接
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.28.128:61616");
            con = connectionFactory.createConnection();
            con.start();
            //创建会话（是否使用事务，消息确认机制）
            session = con.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建目的地（消息队列名称）
            Destination destination = session.createQueue("my-queue");
            //创建消费者（消息接收器）
            MessageConsumer consumer = session.createConsumer(destination);
            //接收消息
            for(int i=0;i<3;i++){
                TextMessage message = (TextMessage)consumer.receive();
                session.commit();
                System.out.println("接收消息："+message.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            con.close();
        }
    }
}
