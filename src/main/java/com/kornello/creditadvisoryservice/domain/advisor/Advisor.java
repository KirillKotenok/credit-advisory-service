package com.kornello.creditadvisoryservice.domain.advisor;

import com.kornello.creditadvisoryservice.domain.application.Application;
import com.kornello.creditadvisoryservice.error.AdvisorAlreadyAssignedException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.kornello.creditadvisoryservice.domain.application.ApplicationStatus.ASSIGNED;

@Entity
@Table(name = "advisors")
@Data
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "advisor")
    private List<Application> applicationList = new ArrayList<>();

    public void assignApplication(Application application) {
        if (this.hasActiveApplication()) throw new AdvisorAlreadyAssignedException();
        this.applicationList.add(application);
        application.assign(this);
    }

    public void removeApplication(Application application) {
        this.applicationList.remove(application);
        application.setAdvisor(null);
    }

    private boolean hasActiveApplication() {
        return applicationList.stream()
                .anyMatch(a -> a.getStatus().equals(ASSIGNED));
    }
}
