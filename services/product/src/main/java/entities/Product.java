package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "product_seq",
            allocationSize = 50
    )
    @Column(name = "product_id")
    private Integer productId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @Positive
    @Column(name = "available_quantity")
    private Integer availableQuantity;
    @Positive
    private Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
