package br.gov.mt.vigilancia.saude.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private boolean useSsl = false;
    private Integer urlExpirationMinutes = 30;
}
