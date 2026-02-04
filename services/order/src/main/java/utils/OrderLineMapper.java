package utils;

import entities.Order;
import entities.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .orderLineId(orderLineRequest.orderLineId())
                .quantity(orderLineRequest.quantity())
                .productId(orderLineRequest.productId())
                .order(
                        Order.builder()
                                .orderId(orderLineRequest.orderId())
                                .build()
                )
                .build();
    }
}
