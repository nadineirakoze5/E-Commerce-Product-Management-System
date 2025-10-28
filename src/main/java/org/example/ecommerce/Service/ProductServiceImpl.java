package org.example.ecommerce.Service;

import org.example.ecommerce.Dto.ProductRequestDto;
import org.example.ecommerce.Dto.ProductResponseDto;
import org.example.ecommerce.ExceptionHandlerHandling.RuntimeExceptionHandling;
import org.example.ecommerce.Model.Product;
import org.example.ecommerce.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<ProductResponseDto> products = new ArrayList<>();

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());

        productRepository.save(product);
        return new ProductResponseDto(product.getId(),product.getName(),product.getPrice(),product.getStockQuantity());
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductResponseDto(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity()))
                .collect(Collectors.toList());

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