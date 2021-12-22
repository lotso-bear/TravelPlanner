package com.example.travelplandemo1.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plansTable")
public class PlanListTable implements Serializable {
    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
