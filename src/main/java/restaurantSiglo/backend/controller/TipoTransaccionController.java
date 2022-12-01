package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Tipo_Transaccion;
import restaurantSiglo.backend.repository.Tipo_TransaccionRepository;

import java.util.List;

@RestController
public class TipoTransaccionController {

    //Obtenemos el Repositorio
    private Tipo_TransaccionRepository tipo_transaccionRepository;

    //Creamos el Constructor
    public TipoTransaccionController(Tipo_TransaccionRepository tipo_transaccionRepository) {
        this.tipo_transaccionRepository = tipo_transaccionRepository;
    }

    //Esta función obtiene a todos los tipos de transacción de la base de datos
    @GetMapping("/tipos_transacciones")
    public List<Tipo_Transaccion> findAll(){
        List<Tipo_Transaccion> tipo_transaccions = tipo_transaccionRepository.findAll();
        return tipo_transaccions;
    }

    //Esta función busca a un tipo de transacción por Id dentro de la base de datos
    @GetMapping("/tipos_transacciones/{id}")
    public ResponseEntity<Tipo_Transaccion> findById(@PathVariable Integer id){
        List<Tipo_Transaccion> tipos_transacciones = tipo_transaccionRepository.findAll();
        for (int i =0;i< tipos_transacciones.size();i++){
            Tipo_Transaccion tm1= tipos_transacciones.get(i);
            if (tm1.getId_tipo_transaccion()==id){
                return ResponseEntity.ok(tm1);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un tipo de transacción dentro de la base de datos
    @DeleteMapping("/tipos_transacciones/{id}")
    public ResponseEntity<Tipo_Transaccion> delete(@PathVariable Integer id){
        List<Tipo_Transaccion> tipos_transacciones = tipo_transaccionRepository.findAll();
        for (int i =0;i< tipos_transacciones.size();i++){
            Tipo_Transaccion tm1= tipos_transacciones.get(i);
            if (tm1.getId_tipo_transaccion()==id){
                tipo_transaccionRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un tipo de transacción en base de datos
    @PostMapping("/tipos_transacciones")
    public ResponseEntity<Tipo_Transaccion> create(@RequestBody Tipo_Transaccion tipo_transaccion){
        if (tipo_transaccion.getId_tipo_transaccion()==null){
            Tipo_Transaccion tm1 = tipo_transaccionRepository.save(tipo_transaccion);
            return ResponseEntity.ok(tm1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un tipo de transacción en base de datos
    @PutMapping("/tipos_transacciones")
    public ResponseEntity<Tipo_Transaccion> update(@RequestBody Tipo_Transaccion tipo_transaccion){
        List<Tipo_Transaccion> tipos_transacciones = tipo_transaccionRepository.findAll();
        for (int i =0;i< tipos_transacciones.size();i++){
            Tipo_Transaccion tm = tipos_transacciones.get(i);
            if (tm.getId_tipo_transaccion() == tipo_transaccion.getId_tipo_transaccion()){
                Tipo_Transaccion tm1 = tipo_transaccionRepository.save(tipo_transaccion);
                return ResponseEntity.ok(tm1);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
