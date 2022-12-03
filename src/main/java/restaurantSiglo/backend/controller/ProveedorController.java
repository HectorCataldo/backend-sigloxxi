package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Proveedor;
import restaurantSiglo.backend.repository.ProveedorRepository;

import java.util.List;

@RestController
public class ProveedorController {

    //Obtenemos el Repositorio
    private ProveedorRepository proveedorRepository;

    //Creamos el Constructor
    public ProveedorController(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    //Esta función obtiene a todos los proveedores de la base de datos
    @GetMapping("/proveedores")
    public List<Proveedor> findAll(){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores;
    }

    //Esta función obtiene a un proveedor por Id dentro de la base de datos
    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable Integer id){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        for (int i = 0; i < proveedores.size(); i++){
            Proveedor proveedor = proveedores.get(i);
            if (proveedor.getId_proveedor()== id){
                return ResponseEntity.ok(proveedor);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función Elimina a un proveedor de la base de datos
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> delete(@PathVariable Integer id){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        for (int i = 0; i < proveedores.size(); i++){
            Proveedor proveedor = proveedores.get(i);
            if (proveedor.getId_proveedor()== id){
                proveedorRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea a un proveedor en la base de datos
    @PostMapping("/proveedores")
    public ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor){
        if (proveedor.getId_proveedor() == null){
            Proveedor p1 = proveedorRepository.save(proveedor);
            return ResponseEntity.ok(p1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un proveedor en la base de datos
    @PutMapping("/proveedores")
    public ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        for (int i = 0; i < proveedores.size(); i++){
            Proveedor proveedor1 = proveedores.get(i);
            if (proveedor1.getId_proveedor() == proveedor.getId_proveedor()){
                Proveedor p1 = proveedorRepository.save(proveedor);
                return ResponseEntity.ok(p1);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
