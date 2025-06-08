package com.example.Inventory.IMT.Controller;

import com.example.Inventory.IMT.Model.User;
import com.example.Inventory.IMT.Service.ProductService;
import com.example.Inventory.IMT.Service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin_only")
@Tag(name = "Admin Operations", description = "APIs only accessible by admin role")
@RequiredArgsConstructor
public class AdminController {

    private final UserDetailsServiceImpl userService;

    private final ProductService productService;

    @Operation(summary = "Get list of all users")
    @ApiResponse(responseCode = "200", description = "All users fetched successfully")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Get the most added product")
    @ApiResponse(responseCode = "200", description = "Most added product retrieved")
    @GetMapping("/most-added-product")
    public ResponseEntity<String> getMostAddedProduct() {
        return ResponseEntity.ok(productService.getMostAddedProductName());
    }
}
