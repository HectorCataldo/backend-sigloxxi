package restaurantSiglo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurantSiglo.backend.entities.Documento_Venta;
import restaurantSiglo.backend.entities.Orden_de_Compra;
import restaurantSiglo.backend.repository.DocumentoVentaRepository;
import restaurantSiglo.backend.repository.PedidoRepository;
import restaurantSiglo.backend.repository.ProductoRepository;
import restaurantSiglo.backend.repository.Tipo_TransaccionRepository;

import javax.print.Doc;
import java.util.List;

@RestController
public class DocumentoVentaController {

    //Obtenemos los repositorios
    private DocumentoVentaRepository documentoVentaRepository;
    private PedidoRepository pedidoRepository;
    private ProductoRepository productoRepository;
    private Tipo_TransaccionRepository tipo_transaccionRepository;

    //Creamos el constructor
    public DocumentoVentaController(DocumentoVentaRepository documentoVentaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, Tipo_TransaccionRepository tipo_transaccionRepository) {
        this.documentoVentaRepository = documentoVentaRepository;
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.tipo_transaccionRepository = tipo_transaccionRepository;
    }

    //Funciones CRUD

    //Esta función obtiene todos los documentos de venta en la base de datos
    @GetMapping("/documentos_venta")
    public List<Documento_Venta> findAll(){
        try {
            List<Documento_Venta>documento_ventas = documentoVentaRepository.findAll();
            return documento_ventas;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

}
