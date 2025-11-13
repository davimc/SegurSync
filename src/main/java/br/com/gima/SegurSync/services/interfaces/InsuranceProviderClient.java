package br.com.gima.SegurSync.services.interfaces;

import br.com.gima.SegurSync.services.dto.PolicyDTO;

import java.util.List;

public interface InsuranceProviderClient {
    String getProviderName();
    List<PolicyDTO> fetchPolicies();
    PolicyDTO fetchPolicyByNumber(String policyNumber);
}
