package customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import utils.CustomerResponse;

import java.util.Optional;

@FeignClient(
        name = "customer-service" // here feign gets the base URL of the customer-service from the eureka server
//        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/api/v1/customers/{id}") //this is the path of the URL that we are hitting.
    Optional<CustomerResponse> findCustomerById(@PathVariable("id") String customerId); //call the customer-ms and get the customer with this id. base url+path
}
