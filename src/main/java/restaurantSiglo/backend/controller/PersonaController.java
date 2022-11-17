package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

    //Obtenemos el Respositorio
    private PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    ///Esta función busca a todas las personas registradas en la base de datos
    @GetMapping("/personas")
    public List<Persona> findAll(){
        return personaRepository.findAll();
    }


    //Esta función obtiene una persona de la base de datos por ID
    @GetMapping("personas/{id}")
    public ResponseEntity<Persona> findOneById(@PathVariable Integer id){

        Optional<Persona> persona = personaRepository.findById(id);

        if (persona.isPresent()){
            return ResponseEntity.ok(persona.get());
        }
        else
            return ResponseEntity.notFound().build();
    }

    //Esta función elimina una persona de la Base de datos
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Persona> deleteById(@PathVariable Integer id){

        if (!personaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
            personaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }

    //Esta función crea una persona en base de datos
/*
    public ResponseEntity<Persona> create(@RequestBody Persona persona){

        if (persona.getId_persona()==null){

        }

    }*/















}
