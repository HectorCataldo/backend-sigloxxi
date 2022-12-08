package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Orden_de_Compra;
import restaurantSiglo.backend.entities.Producto;
import restaurantSiglo.backend.entities.Proveedor;
import restaurantSiglo.backend.repository.OrdenCompraRepository;
import restaurantSiglo.backend.repository.ProductoRepository;
import restaurantSiglo.backend.repository.ProveedorRepository;

import java.util.List;

@RestController
public class OrdenCompraController {

    //Obtenemos los repositorios
    private OrdenCompraRepository ordenCompraRepository;
    private ProveedorRepository proveedorRepository;
    private ProductoRepository productoRepository;

    //Creamos el constructor
    public OrdenCompraController(OrdenCompraRepository ordenCompraRepository, ProveedorRepository proveedorRepository, ProductoRepository productoRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.proveedorRepository = proveedorRepository;
        this.productoRepository = productoRepository;
    }

    //Esta función obtiene a todas las órdenes de compras de la base de datos
    @GetMapping("/orden_compra")
    public List<Orden_de_Compra> findAll(){
        try {
            List<Orden_de_Compra> orden_de_compras = ordenCompraRepository.findAll();
            return orden_de_compras;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función busca y trae una orden de compra por su Id de la base de datos
    @GetMapping("/orden_compra/{id}")
    public ResponseEntity<Orden_de_Compra> findById(@PathVariable Integer id){
        try {
            List<Orden_de_Compra> orden_de_compras = ordenCompraRepository.findAll();
            for (int i =0; i<orden_de_compras.size();i++){
                Orden_de_Compra orden_de_compra = orden_de_compras.get(i);
                if (orden_de_compra.getId_orden_de_compra()== id){
                    return ResponseEntity.ok(orden_de_compra);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina una orden de compra por su Id de la base de datos
    @DeleteMapping("/orden_compra/{id}")
    public ResponseEntity<Orden_de_Compra> delete(@PathVariable Integer id){
        try {
            List<Orden_de_Compra> orden_de_compras = ordenCompraRepository.findAll();
            for (int i =0; i<orden_de_compras.size();i++){
                Orden_de_Compra orden_de_compra = orden_de_compras.get(i);
                if (orden_de_compra.getId_orden_de_compra()== id){
                    ordenCompraRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea una orden de compra en la base de datos
    @PostMapping("/orden_compra")
    public ResponseEntity<Orden_de_Compra> create(@RequestBody Orden_de_Compra orden_de_compra){
        try {
            List<Proveedor> proveedores = proveedorRepository.findAll();
            List<Producto> productos = productoRepository.findAll();
            if (orden_de_compra.getId_orden_de_compra()==null){
                if (orden_de_compra.getNumero_orden()>= 1 && orden_de_compra.getValor_total()>=1 && orden_de_compra.getCantidad()>=1){
                    for (int i =0; i<proveedores.size();i++){
                        Proveedor proveedor = proveedores.get(i);
                        if (proveedor == orden_de_compra.getProveedor()){
                            for (int o=0;o<productos.size();o++){
                                Producto producto = productos.get(o);
                                if (producto == orden_de_compra.getProducto()){
                                    Orden_de_Compra orden_de_compra1 = ordenCompraRepository.save(orden_de_compra);
                                    return ResponseEntity.ok(orden_de_compra1);
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

    //Esta función actualiza los datos de una orden de compra de la base de datos
    @PutMapping("/orden_compra")
    public ResponseEntity<Orden_de_Compra> update(@RequestBody Orden_de_Compra orden_de_compra){
        try {
            List<Proveedor> proveedores = proveedorRepository.findAll();
            List<Producto> productos = productoRepository.findAll();
            List<Orden_de_Compra> orden_de_compras = ordenCompraRepository.findAll();
            for (int c = 0; c<orden_de_compras.size();c++){
                Orden_de_Compra orden_de_compra1 = orden_de_compras.get(c);
                if (orden_de_compra1.getId_orden_de_compra() == orden_de_compra.getId_orden_de_compra()){
                    if (orden_de_compra.getNumero_orden()>= 1 && orden_de_compra.getValor_total()>=1 && orden_de_compra.getCantidad()>=1){
                        for (int i =0; i<proveedores.size();i++){
                            Proveedor proveedor = proveedores.get(i);
                            if (proveedor == orden_de_compra.getProveedor()){
                                for (int o=0;o<productos.size();o++){
                                    Producto producto = productos.get(o);
                                    if (producto == orden_de_compra.getProducto()){
                                        Orden_de_Compra orden = ordenCompraRepository.save(orden_de_compra);
                                        return ResponseEntity.ok(orden);
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
