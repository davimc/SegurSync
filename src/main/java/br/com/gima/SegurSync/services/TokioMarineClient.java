package br.com.gima.SegurSync.services;

import br.com.gima.SegurSync.services.dto.PolicyDTO;
import br.com.gima.SegurSync.services.interfaces.InsuranceProviderClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TokioMarineClient implements InsuranceProviderClient {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.portoseguro.com.br")
            .build();


    @Override
    public String getProviderName() {
        return "Tokio Marine";
    }

    @Override
    public List<PolicyDTO> fetchPolicies() {
        return webClient.get()
                .uri("/policies")
                .retrieve()
                .bodyToFlux(PolicyDTO.class)
                .collectList()
                .block();
    }

    @Override
    public PolicyDTO fetchPolicyByNumber(String policyNumber) {
        return webClient.get()
                .uri("/policies/{number}", policyNumber)
                .retrieve()
                .bodyToMono(PolicyDTO.class)
                .block();
    }
}
