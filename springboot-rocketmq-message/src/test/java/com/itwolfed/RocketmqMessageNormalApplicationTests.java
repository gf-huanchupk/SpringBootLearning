package com.itwolfed;


import com.itwolfed.msg.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketmqMessageNormalApplicationTests {

    @Autowired
    private Producer producer;



    /**
     * 测试普通消息
     */
    @Test
    public void sendMsg() throws Exception {
        producer.sendMsg();
    }

    /**
     * 异步发送普通消息
     */
    @Test
    public void sendAsyncMsg() {
        producer.sendAsyncMsg();
    }

    /**
     * 顺序消息
     */
    @Test
    public void sendOrderlyMsg() {
        producer.sendOrderlyMsg();
    }

    /**
     * 延时消息
     */
    @Test
    public void sendDelayMsg() {
        producer.sendDelayMsg();
    }

    /**
     * 事务消息
     */
    @Test
    public void sendTransactionMsg(){
        producer.sendTransactionMsg();
    }


}
