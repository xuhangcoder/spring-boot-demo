package com.xuhang.springbootdemo;


import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author：xuhang
 * @description：
 * @date：2018/11/8 11:08
 */
public class RocketMqProduce {

    public static void main(String[] args) throws Exception  {
        DefaultMQProducer producer = new DefaultMQProducer("group");
        producer.setVipChannelEnabled(false);
        producer.setNamesrvAddr("47.107.229.30:9876");
        producer.start();

        for (int i = 1 ;i< 100; i++){
            Message msg = new Message("orders", ("orders" + i).getBytes());
            SendResult result = producer.send(msg);
            System.out.println(result);
            System.out.println(msg+"send out");
            Thread.sleep(100);
        }

        producer.shutdown();

    }

}
