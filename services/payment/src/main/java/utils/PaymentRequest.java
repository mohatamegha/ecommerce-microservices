package utils;

import entity.PaymentMethod;
import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
        @NotNull(message = "Payment id cannot be null")
        Integer id, //payment id
        @NotNull(message = "Amount cannot be null")
        double amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
