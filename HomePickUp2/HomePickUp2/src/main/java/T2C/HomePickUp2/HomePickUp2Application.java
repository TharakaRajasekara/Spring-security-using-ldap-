package T2C.HomePickUp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
public class HomePickUp2Application {

	public static void main(String[] args) {
		SpringApplication.run(HomePickUp2Application.class, args);
	}

}
