package top.by.xiceos.config;

import org.springframework.amqp.core.*;
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

    public static final String FANOUT_QUEUE_1 = "fanout.queue.1";
    public static final String FANOUT_QUEUE_2 = "fanout.queue.2";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    public static final String DIRECT_QUEUE_1 = "direct.queue.1";
    public static final String DIRECT_QUEUE_2 ="direct.queue.2" ;
    public static final String DIRECT_EXCHANGE = "direct.exchange";

    public static final String TOPIC_QUEUE_1 = "topic.queue.1";
    public static final String TOPIC_QUEUE_2 = "topic.queue.2";
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

}
