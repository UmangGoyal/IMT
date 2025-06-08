package com.example.Inventory.IMT.Controller;

import com.example.Inventory.IMT.Model.User;
import com.example.Inventory.IMT.Service.ProductService;
import com.example.Inventory.IMT.Service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin_only")
@RequiredArgsConstructor
public class AdminController {

    private final UserDetailsServiceImpl userService;

    private final ProductService productService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/most-added-product")
    public ResponseEntity<String> getMostAddedProduct() {
        return ResponseEntity.ok(productService.getMostAddedProductName());
    }
}
