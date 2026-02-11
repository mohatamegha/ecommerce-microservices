package service;

import entity.Payment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import notification.NotificationProducer;
import notification.PaymentNotificationRequest;
import org.springframework.stereotype.Service;
import repository.PaymentRepo;
import utils.Customer;
import utils.PaymentMapper;
import utils.PaymentRequest;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Payment addPayment(@Valid PaymentRequest paymentRequest) {
        Payment payment = paymentRepo.save(mapper.toPayment(paymentRequest));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment;
    }
}
