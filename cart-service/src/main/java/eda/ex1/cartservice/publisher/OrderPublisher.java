package eda.ex1.cartservice.publisher;

import eda.ex1.cartservice.config.RabbitConfig;
import eda.ex1.cartservice.model.Order;
import eda.ex1.dtos.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private static final Logger logger = LoggerFactory.getLogger(OrderPublisher.class);

    private RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(OrderDTO order) {
        // Publish the order to the defined RabbitMQ queue
        logger.info("Publishing order to RabbitMQ: " + order.toString());
        rabbitTemplate.convertAndSend(RabbitConfig.ORDER_EXCHANGE,"", order);
    }
}

