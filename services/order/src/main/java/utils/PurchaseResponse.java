package utils;

public record PurchaseResponse(
     Integer productId,
     String name,
     String description,
     double price,
     int quantity
) {
}
