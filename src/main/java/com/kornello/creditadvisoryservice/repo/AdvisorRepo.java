package com.kornello.creditadvisoryservice.repo;

import com.kornello.creditadvisoryservice.domain.advisor.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepo extends JpaRepository<Advisor, Long> {
}
