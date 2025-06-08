package com.example.Inventory.IMT.DTO;

import lombok.*;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private int quantity;
    private double price;
    private String type;
    private String image_url;
    private String sku;
    private String Description;

}
