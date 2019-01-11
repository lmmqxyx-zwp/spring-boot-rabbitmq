package top.by.xiceos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.by.xiceos.pattern.TopicSender2;

@Controller
@RequestMapping(value = "/mq")
public class RabbitMQController {

    @Autowired
    private TopicSender2 sender;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/topicSender")
    @ResponseBody
    public String topicSender(@RequestParam String message, @RequestParam(required = false) String routingKey) {
        if (routingKey == null || "".equals(routingKey)) {
            routingKey = "dev.a.sende2.c.v001";
        }

        Object r = sender.send(message, routingKey);

        return "OK";
    }

}
