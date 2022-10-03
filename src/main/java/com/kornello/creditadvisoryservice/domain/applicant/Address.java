package com.kornello.creditadvisoryservice.domain.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private String city;
    private String street;
    private Integer number;
    private Integer zip;
    private Integer apt;
}
