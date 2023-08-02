package com.springboot.repositery;

import com.springboot.dto.AddressDto;
import com.springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositery extends JpaRepository<Address,Integer> {



}
