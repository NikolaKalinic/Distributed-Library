package com.cc.CityLibrary.model;

import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    @Digits(integer = 13, fraction = 0, message = "JMBG must be a numeric value with up to 13 digits.")
    private Long jmbg;
    private String address;
}
