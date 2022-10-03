package com.kornello.creditadvisoryservice.controller;

import com.kornello.creditadvisoryservice.dto.AssignApplicationDto;
import com.kornello.creditadvisoryservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application")
@RequiredArgsConstructor
public class ApplicationAssignmentController {
    private final ApplicationService applicationService;

    @GetMapping("/assign/{advisorId}")
    public ResponseEntity<AssignApplicationDto> assignApplication(@PathVariable Long advisorId) {
        var assignedApplication = applicationService.assign(advisorId);
        return ResponseEntity.ok(new AssignApplicationDto(
                assignedApplication.getId(),
                assignedApplication.getAmount(),
                assignedApplication.getStatus().name(),
                assignedApplication.getCreatedAt(),
                assignedApplication.getAssignedAt(),
                assignedApplication.getResolvedAt(),
                assignedApplication.getApplicant().getId(),
                assignedApplication.getAdvisor().getId()
        ));
    }
}
