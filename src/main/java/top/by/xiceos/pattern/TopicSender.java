package top.by.xiceos.pattern;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.by.xiceos.config.RabbitConfig;
import top.by.xiceos.entity.User;

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RabbitConfig rabbitConfig;

    // 第一个参数：TopicExchange名字
    // 第二个参数：Route-Key
    // 第三个参数：要发送的内容
    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, rabbitConfig.gettRoutingKey1(), user);
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, rabbitConfig.gettRoutingKey2(), user);
    }
}
