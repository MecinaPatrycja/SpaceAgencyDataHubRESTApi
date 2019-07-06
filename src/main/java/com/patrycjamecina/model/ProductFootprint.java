package com.patrycjamecina.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Getter
@Setter
@Entity
public class ProductFootprint extends BaseEntity {
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Point point1;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Point point2;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Point point3;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Point point4;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    public ProductFootprint() {
    }

    public ProductFootprint(Point point1, Point point2, Point point3, Point point4, Product product) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.product = product;
    }
}
