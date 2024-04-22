package dev.theanssgen.io;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = Main.class)
@EnableJpaRepositories(basePackageClasses = Main.class)
public class Main {

	public static void main (String [] args) {
		SpringApplication app = new SpringApplication(Main.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
