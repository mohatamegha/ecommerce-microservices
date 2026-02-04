package product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import utils.CustomerResponse;
import utils.PurchaseRequest;
import utils.PurchaseResponse;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "product-service"
//        url = "${application.config.product-url}"
)
public interface ProductClient {
    @PostMapping("/api/v1/product/purchase")
    List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> requestList);
}
