package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Alerta;
import restaurantSiglo.backend.repository.AlertaRepository;

import java.util.List;

@RestController
public class AlertaController {

    //Obtenemos el Repositorio
    private AlertaRepository alertaRepository;

    //Creamos el Constructor
    public AlertaController(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    //Esta función obtiene a todas las Alertas registradas en base de datos
    @GetMapping("/alertas")
    public List<Alerta> findAll(){
        List<Alerta> alertas = alertaRepository.findAll();
        return alertas;
    }

    @GetMapping("/alertas/{id}")
    public ResponseEntity<Alerta> findById(@PathVariable Integer id){
        List<Alerta> alertas = alertaRepository.findAll();
        for (int i =0; i<alertas.size(); i++){
            Alerta alerta = alertas.get(i);
            if (alerta.getId_alerta()==id){
                return ResponseEntity.ok(alerta);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina una alerta dentro de la base de datos
    @DeleteMapping("/alertas/{id}")
    public ResponseEntity<Alerta> delete(@PathVariable Integer id){
        List<Alerta> alertas = alertaRepository.findAll();
        for (int i =0; i<alertas.size(); i++){
            Alerta alerta = alertas.get(i);
            if (alerta.getId_alerta() == id){
                alertaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea una alerta en la base de datos
    @PostMapping("/alertas")
    public ResponseEntity<Alerta> create(@RequestBody Alerta alerta){
        if (alerta.getId_alerta() == null){
            Alerta a1= alertaRepository.save(alerta);
            return ResponseEntity.ok(a1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de una alerta en la base de datos
    @PutMapping("/alertas")
    public ResponseEntity<Alerta> update(@RequestBody Alerta alerta){
        List<Alerta> alertas = alertaRepository.findAll();
        for (int i =0; i<alertas.size(); i++){
            Alerta alerta1 = alertas.get(i);
            if (alerta1.getId_alerta() == alerta.getId_alerta()){
                Alerta a1 = alertaRepository.save(alerta);
                return ResponseEntity.ok(a1);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
