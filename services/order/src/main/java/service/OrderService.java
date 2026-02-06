package service;

import customer.CustomerClient;
import entities.Order;
import kafka.OrderConfirmation;
import kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import product.ProductClient;
import repository.OrderRepository;
import utils.OrderLineRequest;
import utils.OrderMapper;
import utils.OrderRequest;
import utils.PurchaseRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepo;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Order createOrder(OrderRequest request){
        //check if the customer is valid --> OpenFeign
        var customer = customerClient.findCustomerById(request.customerId()).orElseThrow(() -> new RuntimeException("Cannot create order as customer is not valid!"));
        //purchase the product -> product-microservice
        var purchases = productClient.purchaseProducts(request.productsPurchased());
        //persist order
        Order savedOrder = orderRepo.save(mapper.toOrder(request));
        //persist order lines
        for(PurchaseRequest productRequest : request.productsPurchased()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            savedOrder.getOrderId(),
                            productRequest.productId(),
                            productRequest.quantity()
                    )
            );
        }
        //todo: start payment process(kafka)

        //send the order confirmation --> notification-microservice(kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchases
                )
        );

        return savedOrder;
    }

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order findOrderById(Integer orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }
}
