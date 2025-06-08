package com.example.Inventory.IMT.Service;

import com.example.Inventory.IMT.DTO.ProductRequest;
import com.example.Inventory.IMT.DTO.ProductResponse;
import com.example.Inventory.IMT.Model.Product;
import com.example.Inventory.IMT.Model.User;
import com.example.Inventory.IMT.Repository.ProductRepository;
import com.example.Inventory.IMT.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username).orElseThrow();
    }

    public void addProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .image_url(request.getImage_url())
                .description(request.getDescription())
                .type(request.getType())
                .sku(request.getSku())
                .createdAt(LocalDateTime.now())
                .user(getCurrentUser())
                .build();
        productRepository.save(product);
    }

    public List<ProductResponse> getMyProducts() {
        User user = getCurrentUser();
        return productRepository.findByUser(user).stream()
                .map(p -> ProductResponse.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .image_url((p.getImage_url()))
                        .sku(p.getSku())
                        .type(p.getType())
                        .quantity(p.getQuantity())
                        .price(p.getPrice())
                        .Description(p.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    public void updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow();
        if (!product.getUser().getId().equals(getCurrentUser().getId())) {
            throw new RuntimeException("Unauthorized");
        }

        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setType(request.getType());
        product.setImage_url(request.getImage_url());
        product.setSku(request.getSku());
        product.setDescription(request.getDescription());
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        if (!product.getUser().getId().equals(getCurrentUser().getId())) {
            throw new RuntimeException("Unauthorized");
        }

        productRepository.delete(product);
    }


    public String getMostAddedProductName() {
        Object result = productRepository.findMostAddedProduct();
        if (result instanceof Object[] row) {
            return (String) row[0];  // product name
        } else {
            return "No product data available";
        }
    }

}
