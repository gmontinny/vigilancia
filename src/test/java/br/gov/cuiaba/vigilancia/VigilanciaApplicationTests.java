package br.gov.cuiaba.vigilancia;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import br.gov.mt.vigilancia.saude.VigilanciaApplication;

@SpringBootTest(classes = VigilanciaApplication.class)
@ActiveProfiles("test")
class VigilanciaApplicationTests {

    @Test
    void contextLoads() {
    }

}
