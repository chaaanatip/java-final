// Watchara Santawee (65130500073)
package dev.bestzige.rest_midterm_073.controllers;

import dev.bestzige.rest_midterm_073.dtos.ProductsDTO;
import dev.bestzige.rest_midterm_073.dtos.SuppliersDTO;
import dev.bestzige.rest_midterm_073.entities.Product;
import dev.bestzige.rest_midterm_073.entities.Supplier;
import dev.bestzige.rest_midterm_073.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierController(SupplierService supplierService, ModelMapper modelMapper) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<Set<SuppliersDTO>> getSuppliers() {
        List<Supplier> suppliers = supplierService.getSuppliers();
        Set<SuppliersDTO> results = suppliers.stream().map(s -> modelMapper.map(s, SuppliersDTO.class)).collect(Collectors.toSet());
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{supplierId}/products")
    public ResponseEntity<Set<ProductsDTO>> getSupplierProducts(@PathVariable Integer supplierId) {
        List<Product> products = supplierService.getSupplierProducts(supplierId);
        Set<ProductsDTO> results = products.stream().map(p -> modelMapper.map(p, ProductsDTO.class)).collect(Collectors.toSet());
        return ResponseEntity.ok(results);
    }

    @PostMapping("/{supplierId}/products")
    public ResponseEntity<ProductsDTO> addProductForSupplier(@PathVariable Integer supplierId, @RequestBody Product product) {
        ProductsDTO result = modelMapper.map(supplierService.addProductForSupplier(supplierId, product), ProductsDTO.class);
        return ResponseEntity.ok(result);
    }
}
