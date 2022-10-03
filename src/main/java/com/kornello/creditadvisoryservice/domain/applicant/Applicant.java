package com.kornello.creditadvisoryservice.domain.applicant;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "applicants")
@Data
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "ssn", nullable = false, unique = true)
    @NaturalId
    private String socialSecurityNumber;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "applicant_phone_numbers", joinColumns = @JoinColumn(name = "applicant_id"))
    private Collection<PhoneNumber> phoneNumber = new ArrayList<>();
}
