package org.example.ecommerce.Controller;

import org.example.ecommerce.Dto.ProductRequestDto;
import org.example.ecommerce.Dto.ProductResponseDto;
import org.example.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequest) {
            ProductResponseDto product = productService.createProduct(productRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
            ProductResponseDto product = productService.getProductById(id);
            return ResponseEntity.ok(product);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
            @RequestBody ProductRequestDto productRequest) {
            ProductResponseDto product = productService.updateProduct(id, productRequest);
            return ResponseEntity.ok(product);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
    }

}