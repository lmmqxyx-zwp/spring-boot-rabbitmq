package top.by.xiceos.pattern;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

@Component
public class TopicReceiver {

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_1)
    public void receiveTopic1(User user) {
        System.out.println("[ - receiveTopic1 listen => - ]" + user);
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE_2)
    public void receiveTopic2(User user) {
        System.out.println("[ - receiveTopic2 listen => - ]" + user);
    }
}