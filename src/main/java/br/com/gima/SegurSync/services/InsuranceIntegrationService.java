package br.com.gima.SegurSync.services;

import br.com.gima.SegurSync.services.dto.PolicyDTO;
import br.com.gima.SegurSync.services.interfaces.InsuranceProviderClient;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceIntegrationService {
    private final List<InsuranceProviderClient> providers;

    public InsuranceIntegrationService(List<InsuranceProviderClient> providers) {
        this.providers = providers;
    }

    public void syncAllPolicies() {
        for (InsuranceProviderClient provider : providers) {
            List policies = provider.fetchPolicies();
            // Logic to sync policies with local database
            System.out.println("Syncing " + policies.size() + " policies from " + provider.getProviderName());
        }
    }
    private void savePolicies(String providerName, List<PolicyDTO> policies) {
        throw new NotImplementedException("Implement database save logic here");
    }
}
