package requestAndResponse;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product Id is necessary")
        Integer productId,
        @NotNull(message = "Quantity is necessary")
        Integer quantity
) {
}
