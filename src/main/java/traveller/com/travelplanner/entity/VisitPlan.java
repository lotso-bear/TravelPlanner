package traveller.com.travelplanner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "visitPlan")
public class VisitPlan implements Serializable {
    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitPlanId;

    private String city;

    public void setCity(String city) {this.city = city;}
    public String getCity() {return city;}

    public int getVisitPlanId() {
        return visitPlanId;
    }

    public void setVisitPlanId(int visitPlanId) {
        this.visitPlanId = visitPlanId;
    }

    //这里是做和visits table的一对多关系
    @OneToMany(mappedBy = "visitPlan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VisitItem> visitItemList;

    public List<VisitItem> getVisitItemList() {
        return visitItemList;
    }

    public void setVisitItemList(List<VisitItem> visitTableList) {
        this.visitItemList = visitTableList;
    }
//    //这里是和Customer 1对多的关系
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
