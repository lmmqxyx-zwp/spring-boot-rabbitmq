package top.by.xiceos.pattern;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

import java.util.List;

@Component
public class DirectReceiver {
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_1)
    public void receiveDirect1(List<User> list) {
        if (list != null) {
            for (int i = 0 ; i < list.size(); i++) {
                User u = list.get(i);
                System.out.println("[ - receiveDirect1 listen => - " + (i + 1) + " ]" + u);
            }
        }
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_2)
    public void receiveDirect2(List<User> list) {
        if (list != null) {
            for (int i = 0 ; i < list.size(); i++) {
                User u = list.get(i);
                System.out.println("[ - receiveDirect2 listen => - " + (i + 1) + " ]" + u);
            }
        }
    }
}
