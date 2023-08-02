package com.springboot.repositery;

import com.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepositery  extends JpaRepository<Customer,String> {

    //find Customer By Email
//    @Query("select c from customer c where c.email=:n")
//    public Optional<Customer> getCustomerByEmail(@Param("n") String email);

    //or we acn write
  //  public Optional<Customer> findByEmail(String email);
//=================================================================================================

    //find Customer By email and password

    public Customer findByEmailAndPassword(String email,String password);
    //=================================================================================================

}
