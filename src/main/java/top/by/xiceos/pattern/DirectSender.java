package top.by.xiceos.pattern;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

import java.util.List;

@Component
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitConfig rabbitConfig;

    public void send(List<User> list) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, rabbitConfig.getdRoutingKey1(), list);
    }
}
