package top.by.xiceos.pattern;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

import java.io.IOException;

@Component
public class TopicReceiver2 {

//    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_3)
//    public void receiveTopic(Channel channel, Message message) {
//        System.out.println("[ - TopicReceiver2 receiveTopic listen => - ]" + message);
//        try {
//            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
//            System.out.println(10/0);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//            System.out.println("receiver success");
//        } catch (Exception e) {
//            e.printStackTrace();
//            //丢弃这条消息
//            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
//            System.out.println("receiver fail");
//        }
//    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_3)
    public String receiveTopic(Channel channel, Message message) {
        System.out.println("[ - TopicReceiver2 receiveTopic listen => - ]" + message);
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
//            System.out.println(10/0);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

            System.out.println("receiver success");
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail");
        }

        return "同步消息发送";
    }

}