package top.by.xiceos.pattern;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

@Component
public class FanoutReceiver {

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_1)
    public void receiveFanout1(User user) {
        System.out.println("[ - receiveFanout1 listen => - ]" + user);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_2)
    public void receiveFanout2(User user) {
        System.out.println("[ - receiveFanout2 listen => - ]" + user);
    }
}
