package traveller.com.travelplanner.service;


import traveller.com.travelplanner.dao.CustomerDao;
import traveller.com.travelplanner.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveller.com.travelplanner.entity.VisitPlan;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        customer.setEnabled(true);
//        customer.setVisitPlan(new VisitPlan());
        customerDao.signUp(customer);
    }

        public Customer getCustomer (String email){
            return customerDao.getCustomer(email);
        }
    }
