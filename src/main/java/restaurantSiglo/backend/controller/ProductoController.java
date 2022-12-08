package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.*;
import restaurantSiglo.backend.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class ProductoController {

    //Obtenemos los repositorios
    private ProductoRepository productoRepository;
    private Tipo_MedidaRepository tipo_medidaRepository;
    private Tipo_ProductoRepository tipo_productoRepository;
    private ProveedorRepository proveedorRepository;
    private AlertaRepository alertaRepository;

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    //Creamos el constructor
    public ProductoController(ProductoRepository productoRepository, Tipo_MedidaRepository tipo_medidaRepository, Tipo_ProductoRepository tipo_productoRepository, ProveedorRepository proveedorRepository, AlertaRepository alertaRepository) {
        this.productoRepository = productoRepository;
        this.tipo_medidaRepository = tipo_medidaRepository;
        this.tipo_productoRepository = tipo_productoRepository;
        this.proveedorRepository = proveedorRepository;
        this.alertaRepository = alertaRepository;
    }
    //Esta función sirve para comparar entre dos fechas
    public static boolean compareDates(String d1,String d2)
    {
        try{
            // If you already have date objects then skip 1

            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            System.out.println("Date1"+sdf.format(date1));
            System.out.println("Date2"+sdf.format(date2));System.out.println();

            // Create 2 dates ends
            //1

            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if(date1.after(date2)){
                System.out.println("Date1 is after Date2");
                return true;
            }
            // before() will return true if and only if date1 is before date2
            if(date1.before(date2)){
                System.out.println("Date1 is before Date2");
                return false;
            }

            //equals() returns true if both the dates are equal
            if(date1.equals(date2)){
                System.out.println("Date1 is equal Date2");
                return false;
            }

            System.out.println();
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
        return false;
    }

    //Esta función obtiene y trae a todos los productos de la base de datos
    @GetMapping("/productos")
    private List<Producto> findAll(){
        try {
            List<Producto> productos = productoRepository.findAll();
            return productos;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función obtiene y trae a un producto por su Id de la base de datos
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Integer id){
        try {
            List<Producto> productos = productoRepository.findAll();
            for (int i =0; i<productos.size();i++){
                Producto producto = productos.get(i);
                if (producto.getId_producto() == id){
                    return ResponseEntity.ok(producto);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un producto de la base de datos
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Integer id){
        try {
            List<Producto> productos = productoRepository.findAll();
            for (int i =0; i<productos.size();i++){
                Producto producto = productos.get(i);
                if (producto.getId_producto() == id){
                    productoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un producto dentro de la base de datos
    @PostMapping("/productos")
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        try {
            List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
            List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
            List<Proveedor> proveedores = proveedorRepository.findAll();
            List<Alerta> alertas = alertaRepository.findAll();
            if (producto.getId_producto()==null){
                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                String formatDateTime = localDateTime.format(formatter);
                Date fechaV= producto.getFecha_vencimiento();
                LocalDateTime ldt = LocalDateTime.ofInstant(fechaV.toInstant(), ZoneId.systemDefault());
                if (!producto.getDescripcion().isBlank() && producto.getCantidad() >=1 && compareDates(ldt.format(formatter),formatDateTime)){
                    for (int i = 0; i<tipo_medidas.size();i++){
                        Tipo_Medida tipo_medida = tipo_medidas.get(i);
                        if (tipo_medida == producto.getTipo_medida()){
                            for (int a = 0; a< tipo_productos.size();a++){
                                Tipo_Producto tipo_producto = tipo_productos.get(a);
                                if (tipo_producto== producto.getTipo_producto()){
                                    for (int e = 0; e<proveedores.size();e++){
                                        Proveedor proveedor = proveedores.get(e);
                                        if (proveedor == producto.getProveedor()){
                                            for (int o =0;o<alertas.size();o++){
                                                Alerta alerta = alertas.get(o);
                                                if (alerta == producto.getAlerta()){
                                                    Producto producto1 = productoRepository.save(producto);
                                                    return ResponseEntity.ok(producto1);
                                                }
                                            }
                                        }
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

    //Esta función actualiza los datos de un producto en base de datos
    @PutMapping("/productos")
    public ResponseEntity<Producto> update(@RequestBody Producto producto){
        try {
            List<Tipo_Medida> tipo_medidas = tipo_medidaRepository.findAll();
            List<Tipo_Producto> tipo_productos = tipo_productoRepository.findAll();
            List<Proveedor> proveedores = proveedorRepository.findAll();
            List<Alerta> alertas = alertaRepository.findAll();
            List<Producto> productos = productoRepository.findAll();
            for (int u = 0; u<productos.size(); u++){
                Producto prod= productos.get(u);
                if (prod.getId_producto() == producto.getId_producto()){
                    LocalDateTime localDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                    String formatDateTime = localDateTime.format(formatter);
                    Date fechaV= producto.getFecha_vencimiento();
                    LocalDateTime ldt = LocalDateTime.ofInstant(fechaV.toInstant(), ZoneId.systemDefault());
                    if (!producto.getDescripcion().isBlank() && producto.getCantidad() >=1 && compareDates(ldt.format(formatter),formatDateTime)){
                        for (int i = 0; i<tipo_medidas.size();i++){
                            Tipo_Medida tipo_medida = tipo_medidas.get(i);
                            if (tipo_medida == producto.getTipo_medida()){
                                for (int a = 0; a< tipo_productos.size();a++){
                                    Tipo_Producto tipo_producto = tipo_productos.get(a);
                                    if (tipo_producto== producto.getTipo_producto()){
                                        for (int e = 0; e<proveedores.size();e++){
                                            Proveedor proveedor = proveedores.get(e);
                                            if (proveedor == producto.getProveedor()){
                                                for (int o =0;o<alertas.size();o++){
                                                    Alerta alerta = alertas.get(o);
                                                    if (alerta == producto.getAlerta()){
                                                        Producto producto1 = productoRepository.save(producto);
                                                        return ResponseEntity.ok(producto1);
                                                    }
                                                }
                                            }
                                        }
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
