package de.multimedia.emulation.emil.integration;

import de.multimedia.emulation.emil.integration.config.EmilIntegrationFramworkConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan
@Import(EmilIntegrationFramworkConfig.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
