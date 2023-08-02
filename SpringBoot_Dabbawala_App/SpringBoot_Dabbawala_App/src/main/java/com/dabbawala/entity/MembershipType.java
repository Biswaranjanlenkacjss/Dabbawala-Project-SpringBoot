package com.dabbawala.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipType {

    @Id
    @Column(name = "membership_id")
    private int id;

    @Column(name = "membership_type")
    private String membershipType;

}
