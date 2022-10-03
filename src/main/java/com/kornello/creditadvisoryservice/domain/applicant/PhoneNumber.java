package com.kornello.creditadvisoryservice.domain.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneNumber {
    private String number;
    @Enumerated(EnumType.STRING)
    private NumberType type;
}
