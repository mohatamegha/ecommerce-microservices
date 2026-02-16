package payment;

import entities.PaymentMethod;
import utils.CustomerResponse;

public record PaymentRequest(
        double amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
