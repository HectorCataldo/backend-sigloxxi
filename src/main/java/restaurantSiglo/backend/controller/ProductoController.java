package restaurantSiglo.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import restaurantSiglo.backend.repository.*;

@RestController
public class ProductoController {

    //Obtenemos los repositorios
    private ProductoRepository productoRepository;
    private Tipo_MedidaRepository tipo_medidaRepository;
    private Tipo_ProductoRepository tipo_productoRepository;
    private ProveedorRepository proveedorRepository;
    private AlertaRepository alertaRepository;


}
