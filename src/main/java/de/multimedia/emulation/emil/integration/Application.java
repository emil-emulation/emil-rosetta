package de.multimedia.emulation.emil.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
@SpringBootApplication
@EnableWebMvc
public class Application {
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
}
