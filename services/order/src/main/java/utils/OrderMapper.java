package utils;

import entities.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .orderId(request.orderId())
                .reference(request.reference())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .customerId(request.customerId())
//                .orderLines(null)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
