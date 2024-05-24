// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "suppliers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    private Integer id;
    @NotNull
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String country;
    private String phone;
    private String fax;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;
}
