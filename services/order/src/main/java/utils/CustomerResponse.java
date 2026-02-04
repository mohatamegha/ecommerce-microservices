package utils;

public record CustomerResponse(
        String customerId,
        String firstName,
        String lastName,
        String email
) {
}
