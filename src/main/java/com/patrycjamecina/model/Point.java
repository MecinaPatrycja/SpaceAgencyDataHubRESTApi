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
public class Point extends BaseEntity {
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ProductFootprint productFootprint;
    private double lat;
    private double lng;

    public Point() {
    }

    public Point(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
