package requestAndResponse;

import entities.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ProductPurchaseResponse toProductPurchaseResponse(Product product, int quantityDemanded) {
        return new ProductPurchaseResponse(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantityDemanded
        );
    }
}
