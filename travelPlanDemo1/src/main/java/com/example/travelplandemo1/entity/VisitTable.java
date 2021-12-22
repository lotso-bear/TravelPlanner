package com.example.travelplandemo1.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plannedTable")
public class VisitTable implements Serializable {
    private static final long serialVersionUID = -2455760938054036364L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private AttractionsTable attractionsTable;

    public AttractionsTable getAttractionsTable() {
        return attractionsTable;
    }

    public void setAttractionsTable(AttractionsTable attractionsTable) {
        this.attractionsTable = attractionsTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
