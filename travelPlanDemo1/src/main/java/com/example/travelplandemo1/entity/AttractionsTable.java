package com.example.travelplandemo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "attractionsTable")
public class AttractionsTable implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;
    @Id
    private int id;

    private String name;

    private String description;

    private String imageUrl;

    @ManyToOne
    @JsonIgnore
    private CitiesTable citiesTable;

    public CitiesTable getCitiesTable() {
        return citiesTable;
    }

    public void setCitiesTable(CitiesTable citiesTable) {
        this.citiesTable = citiesTable;
    }
    //   private String 经纬度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
