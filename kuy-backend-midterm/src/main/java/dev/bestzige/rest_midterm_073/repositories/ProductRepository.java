// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.repositories;

import dev.bestzige.rest_midterm_073.entities.Product;
import dev.bestzige.rest_midterm_073.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySupplierId(Integer supplierId);
}
