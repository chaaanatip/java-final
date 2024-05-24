// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.dtos;

import lombok.Data;

@Data
public class ProductsDTO {
    private Integer id;
    private String productName;
    private Double unitPrice;
    private String packageField;
    private Boolean discontinued;
}
