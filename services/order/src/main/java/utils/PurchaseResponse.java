package utils;

public record PurchaseResponse(
     Integer prodcutId,
     String name,
     String description,
     double price,
     int quantity
) {
}
