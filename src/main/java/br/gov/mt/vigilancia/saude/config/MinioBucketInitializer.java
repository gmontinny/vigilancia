package br.gov.mt.vigilancia.saude.config;

import br.gov.mt.vigilancia.saude.service.MinioStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MinioBucketInitializer implements ApplicationRunner {

    private final MinioStorageService storageService;

    @Override
    public void run(ApplicationArguments args) {
        storageService.ensureBucket();
    }
}
