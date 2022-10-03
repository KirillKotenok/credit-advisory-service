package com.kornello.creditadvisoryservice.service;

import com.kornello.creditadvisoryservice.domain.application.Application;

public interface ApplicationService {
    Application assign(Long advisorId);
}
