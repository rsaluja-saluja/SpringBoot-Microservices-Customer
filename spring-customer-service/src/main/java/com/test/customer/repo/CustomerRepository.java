package com.test.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
