package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Bodega_Cocina;
import restaurantSiglo.backend.entities.Producto;
import restaurantSiglo.backend.entities.Receta;
import restaurantSiglo.backend.entities.Tipo_Receta;
import restaurantSiglo.backend.repository.BodegaCocinaRepository;
import restaurantSiglo.backend.repository.ProductoRepository;
import restaurantSiglo.backend.repository.RecetaRepository;
import restaurantSiglo.backend.repository.Tipo_RecetaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecetaController {

    //Obtenemos los repositorios
    private RecetaRepository recetaRepository;
    private Tipo_RecetaRepository tipo_recetaRepository;
    private BodegaCocinaRepository bodegaCocinaRepository;

    //Creamos el constructor
    public RecetaController(RecetaRepository recetaRepository, Tipo_RecetaRepository tipo_recetaRepository, BodegaCocinaRepository bodegaCocinaRepository) {
        this.recetaRepository = recetaRepository;
        this.tipo_recetaRepository = tipo_recetaRepository;
        this.bodegaCocinaRepository = bodegaCocinaRepository;
    }

    //Esta función busca y trae a todas las recetas de la base de datos
    @GetMapping("/recetas")
    public List<Receta> findAll(){
        try {
            List<Receta> recetas = recetaRepository.findAll();
            return recetas;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función busca y trae a una receta por su Id de la base de datos
    @GetMapping("/recetas/{id}")
    public ResponseEntity<Receta> findById(@PathVariable Integer id){
        try {
            List<Receta> recetas = recetaRepository.findAll();
            for (int i =0; i<recetas.size(); i++){
                Receta receta = recetas.get(i);
                if (receta.getId_receta()== id){
                    return ResponseEntity.ok(receta);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina una receta por su Id de la base de datos
    @DeleteMapping("/recetas/{id}")
    public ResponseEntity<Receta> delete(@PathVariable Integer id){
        try {
            List<Receta> recetas = recetaRepository.findAll();
            for (int i =0; i<recetas.size(); i++){
                Receta receta = recetas.get(i);
                if (receta.getId_receta()== id){
                    recetaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e) {
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea una receta en la base de datos
    @PostMapping("/recetas")
    public ResponseEntity<Receta> create(@RequestBody Receta receta){
        try {
            List<Bodega_Cocina> bodega_cocinas = bodegaCocinaRepository.findAll();
            List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
            if (receta.getId_receta()==null){
                if (!receta.getDescripcion().isBlank() && receta.getCantidad() >= 1){
                    for (int i =0; i<bodega_cocinas.size();i++){
                        Bodega_Cocina bodega_cocina = bodega_cocinas.get(i);
                        if (bodega_cocina == receta.getBodega_cocina()){
                            for (int o = 0; o<tipo_recetas.size();o++){
                                Tipo_Receta tipo_receta = tipo_recetas.get(o);
                                if (tipo_receta == receta.getTipo_receta()){
                                    Receta r = recetaRepository.save(receta);
                                    return ResponseEntity.ok(r);
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de una receta en la base de datos
    @PutMapping("/recetas")
    public ResponseEntity<Receta> update(@RequestBody Receta receta){
        try {
            List<Receta> recetas = recetaRepository.findAll();
            List<Bodega_Cocina>bodega_cocinas = bodegaCocinaRepository.findAll();
            List<Tipo_Receta> tipo_recetas = tipo_recetaRepository.findAll();
            for (int re =  0; re<recetas.size();re++){
                Receta receta1 = recetas.get(re);
                if (receta1.getId_receta() == receta.getId_receta()){
                    if (!receta.getDescripcion().isBlank() && receta.getCantidad() >= 1){
                        for (int i =0; i<bodega_cocinas.size();i++){
                            Bodega_Cocina bodega_cocina = bodega_cocinas.get(i);
                            if (bodega_cocina == receta.getBodega_cocina()){
                                for (int o = 0; o<tipo_recetas.size();o++){
                                    Tipo_Receta tipo_receta = tipo_recetas.get(o);
                                    if (tipo_receta == receta.getTipo_receta()){
                                        Receta r = recetaRepository.save(receta);
                                        return ResponseEntity.ok(r);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función obtiene y trae las recetas que tienen stock disponible
    @GetMapping("/recetas/stock")
    public List<Receta> findByStock(){
        try {
            List<Receta> recetas = recetaRepository.findAll();
            List<Receta> recetasD = new ArrayList<>();
            for (int i =0; i< recetas.size();i++){
                Receta receta = recetas.get(i);
                if (receta.getBodega_cocina().getCantidad() >= receta.getCantidad()){
                    recetasD.add(receta);
                }
            }
            return recetasD;

        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }
}



