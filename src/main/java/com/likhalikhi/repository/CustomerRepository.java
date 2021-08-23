package com.likhalikhi.repository;

import com.likhalikhi.exception.ApiRequestException;
import com.likhalikhi.model.Customer;
import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.spi.ExceptionConverter;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.spi.SQLExceptionConverter;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Repository
public class CustomerRepository {


    static final Logger log =  Logger.getLogger(CustomerRepository.class);
    @PersistenceContext
    EntityManager entityManager;

    public Customer save(Customer customer ) {
//        log.warn(customer.getFirstName());
        try {
            entityManager.persist(customer);
        }catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), HttpStatus.BAD_REQUEST,e);
        }
        return customer;
    }

    public Customer findByHandle( String handle ) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer  c where c.handle=:handle", Customer.class);
        query.setParameter("handle",handle);
        return query.getSingleResult();
    }

    public Customer findById ( Long id ) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }


}
