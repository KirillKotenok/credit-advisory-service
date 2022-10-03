package com.kornello.creditadvisoryservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AssignApplicationDto(Long applicationtId, BigDecimal amount, String status, LocalDateTime createdAt,
                                   LocalDateTime assignedAt, LocalDateTime resovledAt, Long applicantnId, Long advisorId) {
}
