package org.example.ecommerce.Dto;

import lombok.Data;
@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private double price;
    private int stockQuantity;
   // private String categoryName;

}
