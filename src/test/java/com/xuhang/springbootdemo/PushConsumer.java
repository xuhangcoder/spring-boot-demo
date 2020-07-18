package com.xuhang.springbootdemo;


import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author：xuhang
 * @description：
 * @date：2018/11/8 11:46
 */
public class PushConsumer {

    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer");
        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr("47.107.229.30:9876");
        try {
        consumer.subscribe("xuhang",null);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener(

                new MessageListenerConcurrently() {
                    @Override
                    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                        MessageExt msg = list.get(0);
                        System.out.println(new String(msg.getBody()));
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;

                    }
                }
        );
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
