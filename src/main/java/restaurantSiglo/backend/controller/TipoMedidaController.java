package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Tipo_Medida;
import restaurantSiglo.backend.repository.Tipo_MedidaRepository;

import java.util.List;

@RestController
public class TipoMedidaController {

    //Obtenemos el Repositorio
    private Tipo_MedidaRepository tipo_medidaRepository;

    //Creamos el Constructor
    public TipoMedidaController(Tipo_MedidaRepository tipo_medidaRepository) {
        this.tipo_medidaRepository = tipo_medidaRepository;
    }

    //Esta función obtiene a todos los tipos de medidas de la base de datos
    @GetMapping("/tipos_medidas")
    public List<Tipo_Medida> findAll(){
        List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
        return tipo_medidas;
    }

    //Esta función busca a un tipo de medida por Id dentro de la base de datos
    @GetMapping("/tipos_medidas/{id}")
    public ResponseEntity<Tipo_Medida> findById(@PathVariable Integer id){
        List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
        for (int i =0;i< tipo_medidas.size();i++){
            Tipo_Medida tm1= tipo_medidas.get(i);
            if (tm1.getId_tipo_medida()==id){
                return ResponseEntity.ok(tm1);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un tipo de medida dentro de la base de datos
    @DeleteMapping("/tipos_medidas/{id}")
    public ResponseEntity<Tipo_Medida> delete(@PathVariable Integer id){
        List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
        for (int i =0;i< tipo_medidas.size();i++){
            Tipo_Medida tm1= tipo_medidas.get(i);
            if (tm1.getId_tipo_medida()==id){
                tipo_medidaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un tipo de medida en base de datos
    @PostMapping("/tipos_medidas")
    public ResponseEntity<Tipo_Medida> create(@RequestBody Tipo_Medida tipo_medida){
        if (tipo_medida.getId_tipo_medida()==null){
            Tipo_Medida tm1 = tipo_medidaRepository.save(tipo_medida);
            return ResponseEntity.ok(tm1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un tipo de medida en base de datos
    @PutMapping("/tipos_medidas")
    public ResponseEntity<Tipo_Medida> update(@RequestBody Tipo_Medida tipo_medida){
        List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
        for (int i =0;i< tipo_medidas.size();i++){
            Tipo_Medida tm = tipo_medidas.get(i);
            if (tm.getId_tipo_medida() == tipo_medida.getId_tipo_medida()){
                Tipo_Medida tm1 = tipo_medidaRepository.save(tipo_medida);
                return ResponseEntity.ok(tm1);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
