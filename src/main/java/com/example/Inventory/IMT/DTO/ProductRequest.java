package com.example.Inventory.IMT.DTO;

import lombok.*;

@Data
public class ProductRequest {
    private String name;
    private String type;
    private String image_url;
    private String sku;
    private int quantity;
    private String Description;
    private double price;
}
