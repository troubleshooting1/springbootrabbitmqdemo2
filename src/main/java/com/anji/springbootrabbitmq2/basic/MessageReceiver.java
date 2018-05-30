package com.anji.springbootrabbitmq2.basic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * author: chenqiang
 * date: 2018/5/28 22:11
 */
@Component
public class MessageReceiver {
    /**
     * 无返回消息的
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = Constant.QUEUE_NAME, durable = "true",exclusive = "false",autoDelete = "false"),
        exchange = @Exchange(value = Constant.EXCHANGE_NAME,ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC, autoDelete = "false"),key = Constant.ROUTING_KEY))
    public void receive(byte[] message){
        System.out.println(">>>>>>>>>>> receive：" + new String(message));
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = Constant.QUEUE_NAME,durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = Constant.EXCHANGE_NAME,ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC,autoDelete = "false"),
        key = Constant.ROUTING_REPLY_KEY))
    public String receiveAndReply(byte[] message){
        System.out.println(">>>>>>>>>>> receive：" + new String(message));
        return ">>>>>>>> I got the message";
    }
}
