package restaurantSiglo.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Tipo_Receta;
import restaurantSiglo.backend.repository.Tipo_RecetaRepository;

import java.util.List;

@RestController
public class TipoRecetaController {

    //Obtenemos el Respositorio
    private Tipo_RecetaRepository tipo_recetaRepository;

    //Creamos el constructor
    public TipoRecetaController(Tipo_RecetaRepository tipo_recetaRepository) {this.tipo_recetaRepository = tipo_recetaRepository;}

    //Esta función busca todos los tipos de recetas guardadas en Base de datos
    @GetMapping("/tipos_recetas")
    public List<Tipo_Receta> findAll(){
        List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
        return tipo_recetas;
    }
    //Esta función busca un tipo de receta por Id dentro de la base de datos
    @GetMapping("/tipos_recetas/{id}")
    public ResponseEntity<Tipo_Receta> findById(@PathVariable Integer id){
        List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
        for (int i = 0; i < tipo_recetas.size(); i++){
            Tipo_Receta tipo_receta = tipo_recetas.get(i);
            if (tipo_receta.getId_tipo_receta() == id){
                return ResponseEntity.ok(tipo_recetas.get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina un tipo de receta por Id dentro de la base de datos
    @DeleteMapping("/tipos_recetas/{id}")
    public ResponseEntity<Tipo_Receta> deleteById(@PathVariable Integer id){
        List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
        for (int i = 0; i < tipo_recetas.size(); i++){
            Tipo_Receta tipo_receta = tipo_recetas.get(i);
            if (tipo_receta.getId_tipo_receta() == id){
                tipo_recetaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un tipo de receta en base de datos
    @PostMapping("/tipos_recetas")
    public ResponseEntity<Tipo_Receta> create(@RequestBody Tipo_Receta tipo_receta){
        if (tipo_receta.getId_tipo_receta() == null){
            Tipo_Receta tp1 = tipo_recetaRepository.save(tipo_receta);
            return  ResponseEntity.ok(tp1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un tipo de receta en base de datos
    @PutMapping("/tipos_recetas")
    public ResponseEntity<Tipo_Receta> update(@RequestBody Tipo_Receta tipo_receta){
        List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
        for (int i = 0; i < tipo_recetas.size(); i++){
            Tipo_Receta tr= tipo_recetas.get(i);
            if (tr.getId_tipo_receta() == tipo_receta.getId_tipo_receta()){
                Tipo_Receta tp1 = tipo_recetaRepository.save(tipo_receta);
                return ResponseEntity.ok(tp1);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
