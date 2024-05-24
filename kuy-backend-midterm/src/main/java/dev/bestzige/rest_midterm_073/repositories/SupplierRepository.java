// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.repositories;

import dev.bestzige.rest_midterm_073.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
