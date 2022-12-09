package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import restaurantSiglo.backend.entities.Pedido;
import restaurantSiglo.backend.repository.MesaRepository;
import restaurantSiglo.backend.repository.PedidoRepository;
import restaurantSiglo.backend.repository.RecetaRepository;

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
}
