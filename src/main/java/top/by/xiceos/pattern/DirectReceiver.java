package top.by.xiceos.pattern;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

@Component
public class DirectReceiver {
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_1)
    public void receiveDirect1(User user) {
        System.out.println("[ - receiveDirect1 listen => - ]" + user);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_2)
    public void receiveDirect2(User user) {
        System.out.println("[ - receiveDirect2 listen => - ]" + user);
    }
}
