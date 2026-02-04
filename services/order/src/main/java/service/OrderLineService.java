package service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderLineRepository;
import utils.OrderLineMapper;
import utils.OrderLineRequest;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    public final OrderLineRepository orderLineRepository;
    public final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = mapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getOrderLineId();
    }

//    public OrderLineService(OrderLineRepository orderLineRepository) {
//        this.orderLineRepository = orderLineRepository;
//    }
}
