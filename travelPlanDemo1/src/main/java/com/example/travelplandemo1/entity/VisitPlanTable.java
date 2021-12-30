package com.example.travelplandemo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "visitPlan")
public class VisitPlanTable implements Serializable {
    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitPlanId;

    public int getVisitPlanId() {
        return visitPlanId;
    }

    public void setVisitPlanId(int visitPlanId) {
        this.visitPlanId = visitPlanId;
    }

    //这里是做和visits table的一对多关系
    @OneToMany(mappedBy = "visitItemId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<VisitItemTable> visitTableList;

    public List<VisitItemTable> getVisitTableList() {
        return visitTableList;
    }

    public void setVisitTableList(List<VisitItemTable> visitTableList) {
        this.visitTableList = visitTableList;
    }
    //这里是和Customer 1对1的关系
    @ManyToOne
    @JsonIgnore
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
