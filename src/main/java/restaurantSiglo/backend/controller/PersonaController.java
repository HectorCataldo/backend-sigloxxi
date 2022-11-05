package restaurantSiglo.backend.controller;

import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    //Obtenemos el Respositorio
    private PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
}
