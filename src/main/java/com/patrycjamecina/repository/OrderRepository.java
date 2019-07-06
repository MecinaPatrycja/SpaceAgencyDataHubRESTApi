package com.patrycjamecina.repository;
import com.patrycjamecina.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderProduct, Long> {
}
