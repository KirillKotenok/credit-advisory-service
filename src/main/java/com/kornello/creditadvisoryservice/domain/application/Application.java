package com.kornello.creditadvisoryservice.domain.application;

import com.kornello.creditadvisoryservice.domain.advisor.Advisor;
import com.kornello.creditadvisoryservice.domain.applicant.Applicant;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.kornello.creditadvisoryservice.domain.application.ApplicationStatus.ASSIGNED;
import static com.kornello.creditadvisoryservice.domain.application.ApplicationStatus.NEW;
import static java.time.LocalDateTime.now;
import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "applications")
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "assigned_at", updatable = false)
    private LocalDateTime assignedAt;

    @Column(name = "resolved_at", updatable = false)
    private LocalDateTime resolvedAt;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    public void assign(Advisor advisor) {
        if (this.status == ASSIGNED) throw new IllegalStateException("Application already assign!");
        requireNonNull(advisor);
        this.setStatus(ASSIGNED);
        this.setAssignedAt(now());
        this.advisor = advisor;
    }

    public void resolve(ApplicationStatus status) {
        if (status == NEW || status == ASSIGNED)
            throw new IllegalArgumentException(String.format("You cannot resolve application set it status %s", status.name()));
        requireNonNull(status);
        this.setStatus(status);
        this.setResolvedAt(now());
    }
}
