package org.example.ecommerce.Service;

import org.example.ecommerce.Dto.ProductRequestDto;
import org.example.ecommerce.Dto.ProductResponseDto;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequest);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequest);
    void deleteProduct(Long id);

    List<ProductResponseDto> getProductsByCategory(String categoryName);
    List<ProductResponseDto> searchProducts(String keyword);
    List<ProductResponseDto> getProductsInPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<ProductResponseDto> getAvailableProducts();
    ProductResponseDto updateStock(Long id, Integer quantity);
}