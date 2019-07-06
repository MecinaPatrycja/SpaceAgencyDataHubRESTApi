package com.patrycjamecina.repository;
import com.patrycjamecina.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
