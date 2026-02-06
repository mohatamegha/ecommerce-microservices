package service;

import entities.OrderLine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.OrderLineRepository;
import utils.OrderLineMapper;
import utils.OrderLineRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    public final OrderLineRepository orderLineRepository;
    public final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = mapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getOrderLineId();
    }

    public List<OrderLine> findOrderLineById(Integer orderId) {
         List<OrderLine> orderLines =  orderLineRepository.findByOrder_OrderId(orderId);
         return orderLines;
    }

//    public OrderLineService(OrderLineRepository orderLineRepository) {
//        this.orderLineRepository = orderLineRepository;
//    }
}
