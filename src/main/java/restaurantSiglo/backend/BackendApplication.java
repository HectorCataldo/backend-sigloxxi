package restaurantSiglo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(BackendApplication.class, args);
	}

}
