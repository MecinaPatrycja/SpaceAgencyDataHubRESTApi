package com.patrycjamecina.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
public class OrderProduct extends BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    private double totalOrderAmount;
    @JsonBackReference
    @OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

    public OrderProduct() {
    }

    public OrderProduct(Date orderDate, List<OrderLineItem> orderLineItems) {
        this.orderDate = orderDate;
        this.orderLineItems = orderLineItems;
    }
}
