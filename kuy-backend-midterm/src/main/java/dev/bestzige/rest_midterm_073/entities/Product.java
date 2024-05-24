// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    @NotNull
    private String productName;
    @Min(value = 0, message = "Price need to greater than 0")
    private Double unitPrice;
    @Column(name = "package")
    private String packageField;
    private Boolean discontinued;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;
}
