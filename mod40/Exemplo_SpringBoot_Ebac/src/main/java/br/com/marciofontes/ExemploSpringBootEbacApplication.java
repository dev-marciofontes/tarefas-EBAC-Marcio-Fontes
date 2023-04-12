package br.com.marciofontes;

import br.com.marciofontes.domain.Cliente;
import br.com.marciofontes.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.marciofontes.repository")
@EntityScan("br.com.marciofontes.*")
public class ExemploSpringBootEbacApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ExemploSpringBootEbacApplication.class);

    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ExemploSpringBootEbacApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        Cliente cliente = createCliente();
        repository.save(cliente);
    }

    private Cliente createCliente() {
        return Cliente.builder()
                .cidade("MG")
                .cpf(12312312310L)
                .email("Teste@teste.com")
                .end("End")
                .estado("SP")
                .nome("Cleyton Rodrigues")
                .numero(102030)
                .tel(10203040L)
                .build();
    }

}
