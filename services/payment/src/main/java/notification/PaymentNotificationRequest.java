package notification;

import entity.PaymentMethod;

public record PaymentNotificationRequest(
        String orderReference,
        Double amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
