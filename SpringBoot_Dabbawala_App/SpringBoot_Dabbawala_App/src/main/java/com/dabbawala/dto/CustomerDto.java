package com.dabbawala.dto;

import com.dabbawala.entity.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {
    private String email;


    private String name;

    private String phoneNo;

    private LocalDate dateOfBirth;

    private MembershipTypeDto membershipTypeDto;
}
