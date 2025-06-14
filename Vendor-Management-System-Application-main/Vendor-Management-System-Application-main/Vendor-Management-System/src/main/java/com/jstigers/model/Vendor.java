package com.jstigers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer VendorID;

    @NotBlank(message = "Vendor name is required")
    private String name;

    @NotNull(message = "Bank account number is required")
    @Positive(message = "Bank account number must be a positive number")
    private Long bankAccountNo;

    @NotBlank(message = "Bank name is required")
    private String bankName;

    @NotBlank(message = "Address line 1 is required")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "City name  is required")
    private String city;

    @NotBlank(message = "Country name is required")
    private String country;

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "\\d{6}", message = "Zip code must be in 6 digits")
    private String zipCode;

   
}
