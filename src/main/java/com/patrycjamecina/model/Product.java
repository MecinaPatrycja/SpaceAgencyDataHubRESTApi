package com.patrycjamecina.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Entity
@Getter
@Setter
public class Product extends BaseEntity {
    @ManyToOne
    private Mission mission;
    @Temporal(TemporalType.TIMESTAMP)
    private Date productAcquisitionDate;
    @OneToOne(cascade = CascadeType.ALL)
    private ProductFootprint productFootprint;
    private double productPrice;
    private String productUrl;

    public Product() {
    }

    public Product(Mission mission, Date productAcquisitionDate, ProductFootprint productFootprint, double productPrice, String productUrl) {
        this.mission = mission;
        this.productAcquisitionDate = productAcquisitionDate;
        this.productFootprint = productFootprint;
        this.productPrice = productPrice;
        this.productUrl = productUrl;
    }
}
