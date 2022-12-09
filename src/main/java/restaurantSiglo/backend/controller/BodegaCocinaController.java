package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Alerta;
import restaurantSiglo.backend.entities.Bodega_Cocina;
import restaurantSiglo.backend.entities.Producto;
import restaurantSiglo.backend.repository.AlertaRepository;
import restaurantSiglo.backend.repository.BodegaCocinaRepository;
import restaurantSiglo.backend.repository.ProductoRepository;

import java.util.List;

@RestController
public class BodegaCocinaController {

    //Obtenemos los repositorios
    private BodegaCocinaRepository bodegaCocinaRepository;
    private AlertaRepository alertaRepository;
    private ProductoRepository productoRepository;

    //Creamos el constructor
    public BodegaCocinaController(BodegaCocinaRepository bodegaCocinaRepository, AlertaRepository alertaRepository, ProductoRepository productoRepository) {
        this.bodegaCocinaRepository = bodegaCocinaRepository;
        this.alertaRepository = alertaRepository;
        this.productoRepository = productoRepository;
    }

    //Esta función obtiene todos los productos de la bodega cocina de la base de datos
    @GetMapping("/bodega_cocina")
    public List<Bodega_Cocina> findAll(){
        try {
            List<Bodega_Cocina> bodega_cocinas = bodegaCocinaRepository.findAll();
            return bodega_cocinas;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función obtiene un producto de la bodega cocina por su Id de la base de datos
    @GetMapping("/bodega_cocina/{id}")
    public ResponseEntity<Bodega_Cocina> findById(@PathVariable Integer id){
        try {
            List<Bodega_Cocina> bodega_cocinas = bodegaCocinaRepository.findAll();
            for (int i =0; i<bodega_cocinas.size();i++){
                Bodega_Cocina  bodega_cocina = bodega_cocinas.get(i);
                if (bodega_cocina.getId_producto_bodega()==id){
                    return ResponseEntity.ok(bodega_cocina);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina un producto de la bodega cocina en la base de datos
    @DeleteMapping("/bodega_cocina/{id}")
    public ResponseEntity<Bodega_Cocina> delete(@PathVariable Integer id){
        try {
            List<Bodega_Cocina> bodega_cocinas = bodegaCocinaRepository.findAll();
            for (int i =0; i<bodega_cocinas.size();i++){
                Bodega_Cocina  bodega_cocina = bodega_cocinas.get(i);
                if (bodega_cocina.getId_producto_bodega()==id){
                    bodegaCocinaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un producto en la bodega cocina dentro de la base de datos
    @PostMapping("/bodega_cocina")
    public ResponseEntity<Bodega_Cocina> create(@RequestBody Bodega_Cocina bodega_cocina){
        try {
            List<Alerta> alertas = alertaRepository.findAll();
            List<Producto> productos = productoRepository.findAll();
            if (bodega_cocina.getId_producto_bodega() == bodega_cocina.getProducto().getId_producto()){
                if (!bodega_cocina.getDescripcion().isBlank() && bodega_cocina.getCantidad() >= 1){
                    for (int i=0; i<alertas.size();i++){
                        Alerta alerta = alertas.get(i);
                        if (alerta == bodega_cocina.getAlerta()){
                            for (int p = 0;p<productos.size();p++){
                                Producto producto = productos.get(p);
                                if (producto == bodega_cocina.getProducto()){
                                    Bodega_Cocina bc= bodegaCocinaRepository.save(bodega_cocina);
                                    Producto producto1 = bodega_cocina.getProducto();
                                    Integer cantidad = producto1.getCantidad();
                                    Integer cantidad2= bodega_cocina.getCantidad();
                                    producto1.setCantidad(cantidad - cantidad2);
                                    productoRepository.save(producto1);
                                    return ResponseEntity.ok(bc);
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

    //Esta función actualiza los datos de un producto de la bodega cocina en la base de datos
    @PutMapping("/bodega_cocina")
    public ResponseEntity<Bodega_Cocina> update(@RequestBody Bodega_Cocina bodega_cocina){
        try {
            List<Bodega_Cocina> bodega_cocinas = bodegaCocinaRepository.findAll();
            List<Alerta> alertas = alertaRepository.findAll();
            List<Producto> productos = productoRepository.findAll();
            for (int i =0;i<bodega_cocinas.size();i++){
                Bodega_Cocina bodega_cocina1 = bodega_cocinas.get(i);
                if (bodega_cocina1.getCantidad() == bodega_cocina.getCantidad()){
                    if (!bodega_cocina.getDescripcion().isBlank()){
                        for (int o = 0; o<alertas.size();o++){
                            Alerta alerta = alertas.get(o);
                            if (alerta == bodega_cocina.getAlerta()){
                                for (int u =0; u<productos.size();u++){
                                    Producto producto = productos.get(u);
                                    if (producto == bodega_cocina.getProducto()){
                                        Bodega_Cocina bodega_cocina2 = bodegaCocinaRepository.save(bodega_cocina);
                                        Integer cantidad = bodega_cocina.getProducto().getCantidad();
                                        Integer cantidad2= bodega_cocina.getCantidad();
                                        Producto producto1 = bodega_cocina.getProducto();
                                        if (cantidad2 > bodega_cocina1.getCantidad()){
                                            Integer cantidad3 = cantidad2- bodega_cocina1.getCantidad();
                                            producto1.setCantidad(cantidad - cantidad3);
                                            productoRepository.save(producto1);
                                        }
                                        return ResponseEntity.ok(bodega_cocina2);
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
        return ResponseEntity.notFound().build();
    }


}
