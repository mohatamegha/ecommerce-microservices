package requestAndResponse;

public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        double price,
        int quantity
) {
}
