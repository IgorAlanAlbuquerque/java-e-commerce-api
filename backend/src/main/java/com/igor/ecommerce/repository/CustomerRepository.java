package com.igor.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
