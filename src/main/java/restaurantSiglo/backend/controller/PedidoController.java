package restaurantSiglo.backend.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
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
    public ResponseEntity<Pedido> create(@RequestParam("id_mesa") Integer id_mesa,@RequestParam("id_receta")Integer id_receta,@RequestParam("descripcion")String descripcion,@RequestParam("estado_pedido")Integer estado_pedido){
        List<Mesa> mesas = mesaRepository.findAll();
        List<Receta> recetas=recetaRepository.findAll();
        for (int i=0;i<mesas.size();i++){
            Mesa mesa = mesas.get(i);
            if (mesa.getId_mesa()==id_mesa){
                Mesa mesaD = new Mesa();
                mesaD.setId_mesa(mesa.getId_mesa());
                mesaD.setCapacidad(mesa.getCapacidad());
                mesaD.setFuncionario(mesa.getFuncionario());
                mesaD.setEstado(mesa.isEstado());
                mesaD.setGrupo(mesa.getGrupo());
                mesaD.setSector(mesa.getSector());
                for (int o=0;o<recetas.size();o++){
                    Receta receta = recetas.get(o);
                    if (receta.getId_receta() == id_receta){
                        Receta recetaD= new Receta();
                        recetaD.setId_receta(receta.getId_receta());
                        recetaD.setDescripcion(receta.getDescripcion());
                        recetaD.setCantidad(receta.getCantidad());
                        recetaD.setTipo_receta(receta.getTipo_receta());
                        recetaD.setImagen(receta.getImagen());
                        recetaD.setNombre(receta.getNombre());
                        recetaD.setPrecio(receta.getPrecio());
                        recetaD.setBodega_cocina(receta.getBodega_cocina());
                        Pedido pedido1 = new Pedido(null,mesaD,recetaD,descripcion,estado_pedido);
                        Pedido ped = pedidoRepository.save(pedido1);
                        return ResponseEntity.ok(ped);
                    }
                }

            }
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
                                    Integer estado = pedido.getEstado_pedido();
                                    if (estado >=1 && estado <=3){
                                        Pedido pedido2 = pedidoRepository.save(pedido);
                                        return ResponseEntity.ok(pedido2);
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

    //Esta función cambia el estado de un pedido
    @PostMapping("/pedido")
    public boolean cambiarEstado(@RequestParam("id_pedido")Integer id_pedido,@RequestParam("estado") Integer estado_pedido){
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            for (int i=0; i<pedidos.size();i++){
                Pedido pedido = pedidos.get(i);
                if (pedido.getId_pedido() == id_pedido){
                    pedido.setEstado_pedido(estado_pedido);
                    pedidoRepository.save(pedido);
                    return true;
                }


            }
        }
        catch (Exception e){
            e.getCause();
        }
        return false;
    }

}
