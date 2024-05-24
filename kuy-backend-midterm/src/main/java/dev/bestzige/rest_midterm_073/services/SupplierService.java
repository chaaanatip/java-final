// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.services;

import dev.bestzige.rest_midterm_073.entities.Product;
import dev.bestzige.rest_midterm_073.entities.Supplier;
import dev.bestzige.rest_midterm_073.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final ProductService productService;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository, ProductService productService) {
        this.supplierRepository = supplierRepository;
        this.productService = productService;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public List<Product> getSupplierProducts(Integer supplierId) {
        if(!supplierRepository.existsById(supplierId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Supplier id '" + supplierId + "' NOT FOUND!!!"
            );
        }

        return productService.getProductsBySupplier(supplierId);
    }

    @Transactional
    public Product addProductForSupplier(Integer supplierId, Product product) {
        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
        if(supplier == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Supplier id '" + supplierId + "' NOT FOUND!!!"
            );
        }
        product.setSupplier(supplier);
        return productService.addProduct(product);
    }
}
