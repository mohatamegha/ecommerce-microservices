package entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    private String id;
    @NotNull(message = "Customer first name is required!")
    private String firstname;
    @NotNull(message = "Customer last name is required!")
    private String lastname;
    @NotNull(message = "Email is needed!")
    @Email(message = "Customer email is not valid!")
    private String email;
    private Address address;
}
