// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.services;

import dev.bestzige.rest_midterm_073.entities.Product;
import dev.bestzige.rest_midterm_073.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsBySupplier(Integer supplierId) {
        return productRepository.findBySupplierId(supplierId);
    }

    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
