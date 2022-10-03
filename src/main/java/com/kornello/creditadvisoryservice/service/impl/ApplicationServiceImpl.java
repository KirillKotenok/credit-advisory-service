package com.kornello.creditadvisoryservice.service.impl;

import com.kornello.creditadvisoryservice.domain.advisor.Advisor;
import com.kornello.creditadvisoryservice.domain.application.Application;
import com.kornello.creditadvisoryservice.error.NoAdvisorFoundException;
import com.kornello.creditadvisoryservice.error.NoApplicationFoundException;
import com.kornello.creditadvisoryservice.repo.AdvisorRepo;
import com.kornello.creditadvisoryservice.repo.ApplicationRepo;
import com.kornello.creditadvisoryservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final AdvisorRepo advisorRepository;
    private final ApplicationRepo applicationRepository;

    @Override
    @Transactional
    public Application assign(Long advisorId) {
        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new NoAdvisorFoundException(String.format("Cannot find advisor with %d id", advisorId)));
        Application application = findApplicationToAdvisor(advisor);
        advisor.assignApplication(application);
        return application;
    }

    private Application findApplicationToAdvisor(Advisor advisor) {
        return applicationRepository.findAllWithNewStatus().stream()
                .filter(application -> inAmountRange(application, advisor))
                .min(Comparator.comparing(Application::getCreatedAt))
                .orElseThrow(() -> new NoApplicationFoundException(
                        String.format("Cannot find application to %s %s", advisor.getLastName(), advisor.getFirstName())));

    }

    private boolean inAmountRange(Application application, Advisor advisor) {
        var actualAmount = application.getAmount();
        var minAdvisorAmount = advisor.getRole().getMinAmount();
        var maxAdvisorAmount = advisor.getRole().getMaxAmount();
        return minAdvisorAmount.compareTo(actualAmount) <= 0 && actualAmount.compareTo(maxAdvisorAmount) < 0;
    }
}
