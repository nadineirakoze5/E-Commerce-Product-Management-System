package org.example.ecommerce.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private double price;
    private int stockQuantity;
   // private Long categoryId;

}