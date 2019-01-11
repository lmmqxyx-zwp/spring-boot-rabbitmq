package top.by.xiceos.pattern;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;

@Component
public class TopicSender2 implements RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Object send(Object messgae, String routingKey) {
        System.out.println("routingKey发送内容 : " + messgae);
//        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("HelloSender 消息发送成功 ");
            }
        });

//        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE+"1", routingKey, messgae);

        // 同步消息发送
        Object o = this.rabbitTemplate.convertSendAndReceive(RabbitConfig.TOPIC_EXCHANGE, routingKey, messgae);

        return o;
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
         System.out.println(message);
         System.out.println(replyCode);
         System.out.println(replyText);
         System.out.println(exchange);
         System.out.println(routingKey);
         // 消息发送失败
    }

//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println(correlationData);
//        System.out.println(ack);
//        System.out.println(cause);
//    }

    // https://blog.csdn.net/zhousenshan/article/details/78787230
    // https://www.oschina.net/question/3630488_2279893

    // https://blog.csdn.net/u013308135/article/details/79228074
    // https://www.cnblogs.com/duoduo264/p/9524493.html
}
