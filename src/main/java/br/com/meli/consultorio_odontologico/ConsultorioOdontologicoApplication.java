package br.com.meli.consultorio_odontologico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsultorioOdontologicoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConsultorioOdontologicoApplication.class, args);

    }

}
