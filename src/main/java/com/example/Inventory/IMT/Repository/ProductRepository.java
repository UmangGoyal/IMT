package com.example.Inventory.IMT.Repository;

import com.example.Inventory.IMT.Model.Product;
import com.example.Inventory.IMT.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUser(User user);

    @Query("SELECT p.name, COUNT(p) as cnt FROM Product p GROUP BY p.name ORDER BY cnt DESC LIMIT 1")
    Object findMostAddedProduct();

}
