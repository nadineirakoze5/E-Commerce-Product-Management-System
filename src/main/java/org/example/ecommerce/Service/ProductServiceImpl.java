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

        if (productRepository.existsByName(product.getName())) {
            throw new RuntimeExceptionHandling("Product with name " + product.getName() + " already exists");
        }

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStockQuantity(productRequest.getStockQuantity());

        productRepository.save(product);
        return new ProductResponseDto(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity());
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductResponseDto(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity()))
                .collect(Collectors.toList());

    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        for (ProductResponseDto product : products) {
            if (product.getId().equals(id)) {
            }
        }
        return products;
    }
}