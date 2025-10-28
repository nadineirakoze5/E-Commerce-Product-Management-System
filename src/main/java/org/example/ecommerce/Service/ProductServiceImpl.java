package org.example.ecommerce.Service;

import org.example.ecommerce.Dto.ProductRequestDto;
import org.example.ecommerce.Dto.ProductResponseDto;
import org.example.ecommerce.ExceptionHandlerHandling.RuntimeExceptionHandling;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<ProductResponseDto> products = new ArrayList<>();

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequest) {
        ProductResponseDto product = new ProductResponseDto();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());

        products.add(product);
        return product;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        ProductResponseDto product = products.stream()
                .filter(products -> products.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (product == null) {
            throw new RuntimeExceptionHandling(id);
        }
        return product;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequest) {
        ProductResponseDto existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(productRequest.getName());
            existingProduct.setPrice(productRequest.getPrice());
            return existingProduct;
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        ProductResponseDto productToDelete = getProductById(id);
        if (productToDelete != null) {
            products.remove(productToDelete);
        }
    }
}