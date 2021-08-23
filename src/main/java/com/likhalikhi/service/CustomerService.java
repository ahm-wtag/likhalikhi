package com.likhalikhi.service;

import com.likhalikhi.model.Customer;
import com.likhalikhi.repository.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Customer findByHandle( String handle ) {
        return repository.findByHandle(handle);
    }

    public Customer findById ( Long id ) {
        return repository.findById(id);
    }

}
