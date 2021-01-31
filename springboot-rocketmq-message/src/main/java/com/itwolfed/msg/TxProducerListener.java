package com.itwolfed.msg;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@RocketMQTransactionListener
public class TxProducerListener implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // 执行本地事务
        System.out.println("TX message listener execute local transaction");
        RocketMQLocalTransactionState result;
        try {
            // 业务代码（ 例如下订单 ）
            result = RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            System.out.println("execute local transaction error");
            result = RocketMQLocalTransactionState.UNKNOWN;
        }
        return result;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        // 检查本地事务（ 例如检查下订单是否成功 ）
        System.out.println("TX message listener check local transaction");
        RocketMQLocalTransactionState result;
        try {
            //业务代码（ 根据检查结果，决定是COMMIT或ROLLBACK ）
            result = RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            // 异常就回滚
            System.out.println("check local transaction error");
            result = RocketMQLocalTransactionState.ROLLBACK;
        }
        return result;
    }

}
