package top.by.xiceos.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: RabbitConfig</p>
 * <p>Description:
 * RabbitMQ的配置
 *      使用@Value注入applications.properties文件中的配置
 *      注意：不能私有化RabbitConfig
 *      创建队列
 *      绑定规则
 * </p>
 *
 * @author zwp
 * @date 2019/1/4 11:44
 */
@Configuration
public class RabbitConfig {

    @Value("${sbr.direct.exchange.routing.key1}")
    private String dRoutingKey1;
    @Value("${sbr.direct.exchange.routing.key2}")
    private String dRoutingKey2;
    @Value("${sbr.topic.exchange.routing.key1}")
    private String tRoutingKey1;
    @Value("${sbr.topic.exchange.routing.key2}")
    private String tRoutingKey2;

    @Value("${sbr.topic.exchange.routing.key3}")
    private String tRoutingKey3;

    public String getdRoutingKey1() {
        return dRoutingKey1;
    }

    public String getdRoutingKey2() {
        return dRoutingKey2;
    }

    public String gettRoutingKey1() {
        return tRoutingKey1;
    }

    public String gettRoutingKey2() {
        return tRoutingKey2;
    }

    public String gettRoutingKey3() {
        return tRoutingKey3;
    }

    public static final String FANOUT_QUEUE_1 = "fanout.queue.1";
    public static final String FANOUT_QUEUE_2 = "fanout.queue.2";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    public static final String DIRECT_QUEUE_1 = "direct.queue.1";
    public static final String DIRECT_QUEUE_2 ="direct.queue.2" ;
    public static final String DIRECT_EXCHANGE = "direct.exchange";

    public static final String TOPIC_QUEUE_1 = "topic.queue.1";
    public static final String TOPIC_QUEUE_2 = "topic.queue.2";
    public static final String TOPIC_QUEUE_3 = "topic.queue.3";
    public static final String TOPIC_EXCHANGE = "topic.exchange";

    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE_1);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE_2);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE_1);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue(DIRECT_QUEUE_2);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(this.getdRoutingKey1());
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(this.getdRoutingKey2());
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE_1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE_2);
    }

    @Bean
    public Queue topicQueue3() {
        return new Queue(TOPIC_QUEUE_3);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(this.gettRoutingKey1());
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(this.gettRoutingKey2());
    }

    @Bean
    public Binding topicBinding3() {
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with(this.gettRoutingKey3());
    }

//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    /**
//     * 定制化的amqp模板
//     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换机后接收ack回调，消息发送到exchange ack
//     * ReturnCallback接口用于实现发送到RabbitMQ交换器，但无相应队列与交换器绑定的回调，即消息发送不到任何一个队列中 ack
//     */
//    @Bean
//    public RabbitTemplate getRabbitTemplate() {
//        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//
//        // 消息返回, yml需要配置 publisher-returns: true
//         rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//             @Override
//             public void returnedMessage(
//                     Message message,
//                     int replyCode,
//                     String replyText,
//                     String exchange,
//                     String routingKey) {
//                 System.out.println(message);
//                 System.out.println(replyCode);
//                 System.out.println(replyText);
//                 System.out.println(exchange);
//                 System.out.println(routingKey);
//             }
//         });
//
//        // 消息确认, yml需要配置 publisher-confirms: true
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                if (ack) {
//                    System.out.println("消息发送成功，id：" + correlationData.getId());
//                } else {
//                    System.out.println("消息发送失败，原因：" + cause);
//                }
//            }
//        });
//
//        return rabbitTemplate;
//    }

}
