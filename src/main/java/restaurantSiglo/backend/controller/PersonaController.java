package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonaController {

    //Obtenemos el Respositorio
    private PersonaRepository personaRepository;

    //Creamos el Constructor
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    ///Esta función busca a todas las personas registradas en la base de datos
    @GetMapping("/personas")
    public List<Persona> findAll(){
        List<Persona> personas = personaRepository.findAll();
        return personas;
    }
    //Esta función busca y obtiene un listado de todas las personas con la misma característica o atributo
    @GetMapping("/persona/listado/{id}")
    public List<Persona> findByAllId(@PathVariable Integer id){
        List <Persona> personas = personaRepository.findAll();
        List <Persona> personasID = new ArrayList<>();
        for (int i= 0; i < personas.size(); i++){
            Persona p1 = personas.get(i);
            if(p1.getId_persona() == id){
                personasID.add(p1);
            }
        }
        return  personasID;
    }


    //Esta función obtiene una persona de la base de datos por ID
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> findOneById(@PathVariable Integer id){
        List <Persona> personas = personaRepository.findAll();
        for (int i= 0; i < personas.size(); i++){
            Persona p1 = personas.get(i);
            if(p1.getId_persona() == id){
                return ResponseEntity.ok(personas.get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina una persona de la Base de datos
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Persona> deleteById(@PathVariable Integer id){
        List<Persona> personas = personaRepository.findAll();
        for (int i=0; i < personas.size(); i++){
            Persona p1 = personas.get(i);
            if(p1.getId_persona() == id){
                personaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }

        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea una persona en base de datos
    @PostMapping("/personas")
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
            List<Persona> personas = personaRepository.findAll();
            for (int i = 0; i < personas.size(); i++){
                Persona p1 = personas.get(i);
                if (p1.getRut().equals(persona.getRut()) || persona.getId_persona() != null){
                    return ResponseEntity.badRequest().build();
                }
                else{
                    Persona per = personaRepository.save(persona);
                    return ResponseEntity.ok(per);
                }
            }

        return ResponseEntity.badRequest().build();
    }
        //Esta función actualiza los datos de una persona en base de datos
    @PutMapping("/personas")
    public ResponseEntity<Persona> update(@RequestBody Persona persona){
        try {
            List<Persona> personas = personaRepository.findAll();
            for (int i = 0; i < personas.size(); i++){
                Persona p1 = personas.get(i);
                if (p1.getId_persona() == persona.getId_persona()){
                    if (personas.get(i).getRut() != persona.getRut()){
                        Persona persona1 = personaRepository.save(persona);
                        return ResponseEntity.ok(persona1);
                    }
                } else if (persona.getId_persona() == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
        }catch (Exception e){
            e.getCause();
        }

        return ResponseEntity.notFound().build();
    }















}
