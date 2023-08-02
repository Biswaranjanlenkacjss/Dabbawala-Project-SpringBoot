package com.dabbawala.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerCartDto {
    private int cartId;

    private CustomerDto customerDto;

    private List<RecipeDto> recipeDtos;
}
