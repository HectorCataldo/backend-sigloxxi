package restaurantSiglo.backend.controller;

import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Mesa;
import restaurantSiglo.backend.entities.Pedido;
import restaurantSiglo.backend.entities.Receta;
import restaurantSiglo.backend.repository.MesaRepository;
import restaurantSiglo.backend.repository.PedidoRepository;
import restaurantSiglo.backend.repository.RecetaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController {

    //Obtenemos los repositorios
    private PedidoRepository pedidoRepository;
    private MesaRepository mesaRepository;
    private RecetaRepository recetaRepository;

    //Creamos el constructor
    public PedidoController(PedidoRepository pedidoRepository, MesaRepository mesaRepository, RecetaRepository recetaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.mesaRepository = mesaRepository;
        this.recetaRepository = recetaRepository;
    }

    //Esta función obtiene todos los pedidos de la base de datos
    @GetMapping("/pedidos")
    public List<Pedido> findAll(){
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            return pedidos;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función obtiene un pedido por su Id de la base de datos
    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id){
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            for (int i =0; i<pedidos.size();i++){
                Pedido pedido =pedidos.get(i);
                if (pedido.getId_pedido()==id){
                    return ResponseEntity.ok(pedido);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina un pedido por su ID de la base de datos
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable Integer id){
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            for (int i =0; i<pedidos.size();i++){
                Pedido pedido =pedidos.get(i);
                if (pedido.getId_pedido()==id){
                    pedidoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un pedido en base de datos
    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
        try {
            List<Mesa>mesas=mesaRepository.findAll();
            List<Receta>recetas = recetaRepository.findAll();
            if (pedido.getId_pedido() ==null){
                for (int i =0;i<mesas.size();i++){
                    Mesa mesa = mesas.get(i);
                    if (mesa == pedido.getMesa()){
                        for (int o=0;o<recetas.size();o++){
                            Receta receta= recetas.get(o);
                            if (receta == pedido.getReceta()){
                                Pedido pedido1 = pedidoRepository.save(pedido);
                                return ResponseEntity.ok(pedido1);
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

    //Esta función actualiza los datos de un pedido en base de datos
    @PutMapping("/pedidos")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
        try {
            List<Pedido>pedidos = pedidoRepository.findAll();
            List<Mesa> mesas = mesaRepository.findAll();
            List<Receta> recetas = recetaRepository.findAll();
            for (int i =0; i<pedidos.size(); i++){
                Pedido pedido1 = pedidos.get(i);
                if (pedido1.getId_pedido() == pedido.getId_pedido()){
                    for (int o = 0;o<mesas.size();o++){
                        Mesa mesa= mesas.get(o);
                        if (mesa==pedido.getMesa()){
                            for (int u =0;u<recetas.size();u++){
                                Receta receta = recetas.get(u);
                                if (receta == pedido.getReceta()){
                                    Pedido pedido2 = pedidoRepository.save(pedido);
                                    return ResponseEntity.ok(pedido2);
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
    //Esta función obtiene una lista de todos los pedidos de una sola mesa por ID de la mesa
    @GetMapping("/pedidos/mesa/{id}")
    public List<Pedido> findByMesa(@PathVariable Integer id){
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            List<Pedido> pedidosM= new ArrayList<>();
            for (int i=0; i<pedidos.size();i++){
                Pedido pedido = pedidos.get(i);
                if (pedido.getMesa().getId_mesa()==id){
                    pedidosM.add(pedido);
                }
            }
            return pedidosM;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }
}
