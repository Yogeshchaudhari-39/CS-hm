package com.codingshuttle.assignments.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


    private Integer id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 4, max = 30, message = "Department title should minimum 4 character and max 30 ")
    private String title;

    @JsonProperty(value = "isActive")
    private Boolean isActive;


    private LocalDateTime localDateTime;

}
