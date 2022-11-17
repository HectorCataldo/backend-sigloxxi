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

	/*	PersonaRepository personaRepository = context.getBean(PersonaRepository.class);

		Persona persona1 = new Persona(null,"20200200-2","Juan","Perez",956567842,"juanperez@example.com","Av Las Lolas 5352");
		Persona persona2 = new Persona(null,"10100100-1","Juana","Lopez",956481380,"juanalopez@example.com","Av Las Lolas 5051");

		personaRepository.save(persona1);
		personaRepository.save(persona2); */



	}

}
