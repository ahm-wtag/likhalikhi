package com.likhalikhi.service;

import com.likhalikhi.model.Customer;
import com.likhalikhi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public void save(Customer customer) {
        repository.save(customer);
    }

    public Customer findByHandle( String handle ) {
        return repository.findByHandle(handle);
    }

    public Customer findById ( Long id ) {
        return repository.findByID(id);
    }

}
