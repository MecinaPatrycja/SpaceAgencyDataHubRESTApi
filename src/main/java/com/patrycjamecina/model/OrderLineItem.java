package com.patrycjamecina.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Setter
public class OrderLineItem extends BaseEntity {
    private int quantity;
    private Long productId;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderProduct orderProduct;

    public OrderLineItem() {
    }

    public OrderLineItem(int quantity, Long productId, OrderProduct orderProduct) {
        this.quantity = quantity;
        this.productId = productId;
        this.orderProduct = orderProduct;
    }
}
