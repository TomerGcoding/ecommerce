package eda.ex1.orderservice.consumer;

import eda.ex1.orderservice.model.Order;
import eda.ex1.orderservice.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderConsumer(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @RabbitListener(queues = "#{rabbitMQConfig.ORDER_QUEUE}")
    public void receiveOrder(Order order) {
        // Log the received order
        logger.info("Received Order: {}", order.getOrderId());

        // Calculate shipping cost (2% of total amount)
        double shippingCost = order.getTotalAmount() * 0.02;
        logger.info("Shipping Cost for Order {}: {}",
                order.getOrderId(),
                String.format("%.2f %s", shippingCost, order.getCurrency())
        );

        // Store the order in the repository
        ordersRepository.addOrder(order);

        // Log additional order details
        logger.info("Order Details - Customer: {}, Total Items: {}, Total Amount: {} {}",
                order.getCustomerId(),
                order.getNumOfItems(),
                order.getTotalAmount(),
                order.getCurrency()
        );
    }
}