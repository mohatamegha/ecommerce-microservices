package utils;

public record OrderLineRequest(
        Integer orderLineId,
        Integer orderId,
        Integer productId,
        Integer quantity
) {
}
