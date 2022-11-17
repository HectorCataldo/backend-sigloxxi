package restaurantSiglo.backend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll(){
        List<Persona> personas = personaRepository.findAll();
        return personas;
    }

    public ResponseEntity<Persona> findById(Integer id){
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()){
           return ResponseEntity.ok(persona.get());
        }
        else
            return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Persona> deleteById(Integer id){

        if (!personaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        personaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
