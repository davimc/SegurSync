package br.com.gima.SegurSync.services.dto;

import lombok.Builder;


@Builder
public record PolicyDTO(Integer policyNumber, String holderName, String insurer, String startDate, String endDate, String status, Double premiunValue) {
}
