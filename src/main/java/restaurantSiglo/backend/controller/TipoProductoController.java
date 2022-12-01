package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Tipo_Medida;
import restaurantSiglo.backend.entities.Tipo_Producto;
import restaurantSiglo.backend.repository.Tipo_ProductoRepository;

import java.util.List;

@RestController
public class TipoProductoController {

    //Obtenemos el Repositorio
    private Tipo_ProductoRepository tipo_productoRepository;

    //Creamos el Constructor
    public TipoProductoController(Tipo_ProductoRepository tipo_productoRepository) {
        this.tipo_productoRepository = tipo_productoRepository;
    }

    //Esta función obtiene a todos los tipos de productos de la base de datos
    @GetMapping("/tipos_productos")
    public List<Tipo_Producto> findAll(){
        List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
        return tipo_productos;
    }

    //Esta función obtiene a un tipo de producto por Id de la base de datos
    @GetMapping("/tipos_productos/{id}")
    public ResponseEntity<Tipo_Producto> findById(@PathVariable Integer id){
        List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
        for (int i=0; i < tipo_productos.size(); i++){
            Tipo_Producto tipo_producto = tipo_productos.get(i);
            if (tipo_producto.getId_tipo_producto() == id){
                return ResponseEntity.ok(tipo_producto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un tipo de producto por Id de la base de datos
    @DeleteMapping("/tipos_productos/{id}")
    public ResponseEntity<Tipo_Producto> delete(@PathVariable Integer id){
        List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
        for (int i=0; i < tipo_productos.size(); i++){
            Tipo_Producto tipo_producto = tipo_productos.get(i);
            if (tipo_producto.getId_tipo_producto() == id){
                tipo_productoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un tipo de producto en la base de datos
    @PostMapping("/tipos_productos")
    public ResponseEntity<Tipo_Producto> create(@RequestBody Tipo_Producto tipo_producto){
        if (tipo_producto.getId_tipo_producto()==null){
            Tipo_Producto tp1 = tipo_productoRepository.save(tipo_producto);
            return ResponseEntity.ok(tp1);
        }
        return ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un tipo de producto en base de datos
    @PutMapping("/tipos_productos")
    public ResponseEntity<Tipo_Producto> update(@RequestBody Tipo_Producto tipo_producto){
        List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
        for (int i=0; i < tipo_productos.size(); i++){
            Tipo_Producto tipo_producto1 = tipo_productos.get(i);
            if (tipo_producto1.getId_tipo_producto() == tipo_producto.getId_tipo_producto()){
                Tipo_Producto tp1 = tipo_productoRepository.save(tipo_producto);
                return ResponseEntity.ok(tp1);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
