package eda.ex1.orderservice.consumer;

import eda.ex1.dtos.OrderDTO;
import eda.ex1.orderservice.config.RabbitMQConfig;
import eda.ex1.orderservice.mapper.DTOMapper;
import eda.ex1.orderservice.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
    private final OrdersRepository ordersRepository;

    public OrderConsumer(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void receiveOrder(OrderDTO order) {
        logger.info("Received order from RabbitMQ: " + order.toString());
        if(order.getOrderStatus().equals("new")) {
            logger.info("Order status is new, adding order to repository");
            ordersRepository.addOrder(DTOMapper.mapOrderDTOToOrder(order));
            logger.info("Order added to repository: " + order.toString());
        }
    }
}