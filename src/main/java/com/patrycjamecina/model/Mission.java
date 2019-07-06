package com.patrycjamecina.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
public class Mission {
    @Id
    private String missionName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date missionStartDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date missionFinishDate;
    private String imageryType;
    @JsonBackReference
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Mission() {
    }

    public Mission(String missionName, Date missionStartDate, Date missionFinishDate, String imageryType, List<Product> products) {
        this.missionName = missionName;
        this.missionStartDate = missionStartDate;
        this.missionFinishDate = missionFinishDate;
        this.imageryType = imageryType;
        this.products = products;
    }
}
