package com.itwolfed.msg;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class Producer {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 普通消息
     */
    public void sendMsg() throws Exception {

        Message message = new Message(
                // 普通消息所属的Topic
                "Topic-Normal",
                // Message Tag可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在消息队列 RocketMQ 版的服务器过滤。
                "TagA",
                // Message Body可以是任何二进制形式的数据。
                "Hello MQ".getBytes()
        );
        rocketMQTemplate.getProducer().send( message );
        // 等同于上面的方式(常用)
        //rocketMQTemplate.convertAndSend("Topic-Normal:TagA","Hello MQ".getBytes());
    }

    /**
     * 异步发送普通消息
     */
    public void sendAsyncMsg() {
        Map<String, Object> map = new HashMap<>();
        map.put( "name", "zs" );
        map.put( "age", 20 );

        rocketMQTemplate.asyncSend( "Topic-Normal", map, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 消息发送成功。
                log.info( "async send success" );
            }

            @Override
            public void onException(Throwable throwable) {
                // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理。
                log.info( "async send fail" );
            }
        } );
    }

    /**
     * 顺序消息
     */
    public void sendOrderlyMsg() {
        //根据指定的hashKey按顺序发送
        for (int i = 0; i < 1000; i++) {
            String orderId = "biz_" + i % 10;
            // 分区顺序消息中区分不同分区的关键字段，Sharding Key与普通消息的key是完全不同的概念。
            // 全局顺序消息，该字段可以设置为任意非空字符串。
            String shardingKey = String.valueOf( orderId );
            try {
                SendResult sendResult = rocketMQTemplate.syncSendOrderly( "Topic-Order", "send order msg".getBytes(), shardingKey );
                // 发送消息，只要不抛异常就是成功。
                if (sendResult != null) {
                    System.out.println( new Date() + " Send mq message success . msgId is:" + sendResult.getMsgId() );
                }
            } catch (Exception e) {
                // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理。
                System.out.println( new Date() + " Send mq message failed" );
                e.printStackTrace();
            }
        }
    }

    /**
     * 延时消息
     */
    public void sendDelayMsg() {
        rocketMQTemplate.syncSend( "Topic-Delay",
                MessageBuilder.withPayload( "Hello MQ".getBytes() ).build(),
                3000,
                //设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
                //messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
                3 );
    }

    /**
     * 批量消息
     */
    public void sendBatchMsg(List<Message> messages) {
        rocketMQTemplate.syncSend( "springboot-rocketmq", messages );

    }

    /**
     * 事务消息
     */
    public void sendTransactionMsg(){
        TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(
                "Topic-Tx:TagA",
                MessageBuilder.withPayload( "Hello MQ transaction===".getBytes() ).build(),
                null );
        SendStatus sendStatus = transactionSendResult.getSendStatus();
        LocalTransactionState localTransactionState = transactionSendResult.getLocalTransactionState();

        System.out.println( new Date() + " Send mq message status "+ sendStatus +" ,  localTransactionState "+ localTransactionState );
    }


}
