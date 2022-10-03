package com.kornello.creditadvisoryservice.repo;

import com.kornello.creditadvisoryservice.domain.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
    @Query("select a from Application a where a.status = 'NEW'")
    List<Application> findAllWithNewStatus();
}
