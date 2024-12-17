package com.example.MobileShop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class product {
    @Id
    private String id;
    private String name;
    private String brand;
    private String imageUrl;
    private double price;
    private boolean inStock;
    
}
