package org.example.ecommerce.Dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
    private String categoryName;

}
