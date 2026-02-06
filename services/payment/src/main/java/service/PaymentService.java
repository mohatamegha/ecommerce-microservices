package service;

import entity.Payment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PaymentRepo;
import utils.PaymentMapper;
import utils.PaymentRequest;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final PaymentMapper mapper;

    public Payment addPayment(@Valid PaymentRequest paymentRequest) {
        paymentRepo.save(mapper.toPayment(paymentRequest));
    }
}
