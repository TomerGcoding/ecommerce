package eda.ex1.cartservice.publisher;

import eda.ex1.cartservice.config.RabbitConfig;
import eda.ex1.cartservice.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(Order order) {
        // Publish the order to the defined RabbitMQ queue
        rabbitTemplate.convertAndSend(RabbitConfig.ORDER_QUEUE, order);
    }
}

