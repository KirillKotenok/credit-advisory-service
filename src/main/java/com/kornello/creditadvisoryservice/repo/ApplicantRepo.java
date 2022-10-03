package com.kornello.creditadvisoryservice.repo;

import com.kornello.creditadvisoryservice.domain.applicant.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepo extends JpaRepository<Applicant,Long> {
}
