package org.example.ecommerce.Service;

import org.example.ecommerce.Dto.ProductRequestDto;
import org.example.ecommerce.Dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequest);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
//    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequest);
//    void deleteProduct(Long id);

}