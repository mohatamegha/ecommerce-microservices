package service;

import entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer createCustomer(@Valid Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer updateCustomer(@Valid Customer customer) {
        if (customer.getId() == null)
            throw new IllegalArgumentException("Customer ID is required for update");
        Optional<Customer> oldCustomer = customerRepository.findById(customer.getId());
        if(oldCustomer.isEmpty())
            throw new RuntimeException("Customer not present");
        Customer updatedCustomer = oldCustomer.get();
        if(customer.getEmail()!=null)
            updatedCustomer.setEmail(customer.getEmail());
        if(customer.getFirstname()!=null)
            updatedCustomer.setFirstname(customer.getFirstname());
        if(customer.getLastname()!=null)
            updatedCustomer.setLastname(customer.getLastname());
        if(customer.getAddress()!=null)
            updatedCustomer.setAddress(customer.getAddress());
        return customerRepository.save(updatedCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean deleteCustomer(String id){
        Customer customer = getById(id);
        if(customer!=null) {
            customerRepository.delete(customer);
            return true;
        }
        else
            return false;
    }
}
