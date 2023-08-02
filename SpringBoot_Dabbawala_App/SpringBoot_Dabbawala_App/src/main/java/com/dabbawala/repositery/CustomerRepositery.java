package com.dabbawala.repositery;

import com.dabbawala.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositery extends JpaRepository<Customer,String> {
}
