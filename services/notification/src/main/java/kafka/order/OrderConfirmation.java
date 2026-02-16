package kafka.order;

import kafka.payment.PaymentMethod;

public record OrderConfirmation(
        String orderReference,
        double totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
