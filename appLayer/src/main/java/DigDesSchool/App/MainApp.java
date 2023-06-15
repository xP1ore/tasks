package DigDesSchool.App;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("DigDesSchool")
@EnableJpaRepositories("DigDesSchool.repositories")
@SpringBootApplication
@EntityScan("DigDesSchool.models")
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(MainApp.class).headless(false).run(args);
    }
}
