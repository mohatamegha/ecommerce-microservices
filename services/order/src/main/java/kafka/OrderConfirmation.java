package kafka;

import entities.PaymentMethod;
import utils.CustomerResponse;
import utils.PurchaseResponse;

import java.util.List;

public record OrderConfirmation(
        String orderReference,
        double amount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products
) {
}
