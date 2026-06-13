package com.codingshuttle.assignments.dto;

import com.codingshuttle.assignments.annotation.Password;
import com.codingshuttle.assignments.annotation.PrimeNumber;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    private long id;

    @NotBlank(message = "Name Cannot be blank")
    @Size(min = 3, max = 10, message = "name should be minimum 3 and max 10 characters")
    private String name;

    private String address;
    @Email(message = "invalid emailId")
    private String email;

    @JsonProperty(value = "isActive")
    private boolean isActive;

    @DecimalMin(value = "1000.52")
    @DecimalMax(value = "1000000.12")
    private Double salary;

    @Size(min = 10,max = 10)
    private String contactNumber;

    @PrimeNumber(message = "number is not prime")
    private int number;

    @Password(message = "password cannot be null")
    private String password;


}
