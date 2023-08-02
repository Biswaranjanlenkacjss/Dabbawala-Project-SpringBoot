package com.dabbawala.repositery;

import com.dabbawala.entity.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepositery extends JpaRepository<MembershipType,Integer> {
}
