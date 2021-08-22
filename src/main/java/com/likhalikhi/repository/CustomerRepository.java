package com.likhalikhi.repository;

import com.likhalikhi.model.Customer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class CustomerRepository {


    static final Logger log =  Logger.getLogger(CustomerRepository.class);
    @PersistenceContext
    EntityManager entityManager;

    public void save(Customer customer ) {
//        log.warn(customer.getFirstName());
        entityManager.persist(customer);
    }

    public Customer findByHandle( String handle ) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer  c where c.handle=:handle", Customer.class);
        query.setParameter("handle",handle);
        return query.getSingleResult();
    }

    public Customer findByID ( Long id ) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }


}
