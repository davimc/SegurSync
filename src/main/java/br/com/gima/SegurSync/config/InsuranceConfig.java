package br.com.gima.SegurSync.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "insurance")
public class InsuranceConfig {
    private List<ProviderConfig> providers;

    @Data
    public static class ProviderConfig {
        private String name;
        private String apiUrl;
        private String apiKey;
    }

}
