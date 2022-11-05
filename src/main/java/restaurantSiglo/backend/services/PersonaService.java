package restaurantSiglo.backend.services;

import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll(){
        List<Persona> personas = personaRepository.findAll();
        return personas;
    }


}
