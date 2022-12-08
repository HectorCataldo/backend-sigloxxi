package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Funcionario;
import restaurantSiglo.backend.entities.Mesa;
import restaurantSiglo.backend.entities.Sector;
import restaurantSiglo.backend.repository.FuncionarioRepository;
import restaurantSiglo.backend.repository.MesaRepository;
import restaurantSiglo.backend.repository.SectorRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MesaController {
    //Obtenemos los repositorios
    private MesaRepository mesaRepository;
    private SectorRepository sectorRepository;
    private FuncionarioRepository funcionarioRepository;

    //Creamos el constructor
    public MesaController(MesaRepository mesaRepository, SectorRepository sectorRepository, FuncionarioRepository funcionarioRepository) {
        this.mesaRepository = mesaRepository;
        this.sectorRepository = sectorRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    //Esta función obtiene todas las mesas que existen en base de datos
    @GetMapping("/mesa")
    public List<Mesa> findAll(){
        try {
            List<Mesa> mesas = mesaRepository.findAll();
            return mesas;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }
    //Esta función obtiene una mesa por ID de la base de datos
    @GetMapping("/mesa/{id}")
    public ResponseEntity<Mesa> findById(@PathVariable Integer id){
        try {
            List<Mesa> mesas = mesaRepository.findAll();
            for (int i =0; i< mesas.size();i++){
                Mesa mesa = mesas.get(i);
                if (mesa.getId_mesa() == id){
                    return ResponseEntity.ok(mesa);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }
    //Esta función elimina a una mesa por Id de la base de datos
    @DeleteMapping("/mesa/{id}")
    public ResponseEntity<Mesa> delete(@PathVariable Integer id){
        try {
            List<Mesa> mesas = mesaRepository.findAll();
            for (int i =0; i< mesas.size();i++){
                Mesa mesa = mesas.get(i);
                if (mesa.getId_mesa() == id){
                    mesaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea una mesa en la base de datos
    @PostMapping("/mesa")
    public ResponseEntity<Mesa> create (@RequestBody Mesa mesa){
        try {
            List<Sector> sectores = sectorRepository.findAll();
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            if (mesa.getId_mesa() == null){
                if (mesa.getCapacidad() >= 1){
                    for (int i=0;i<sectores.size();i++){
                        Sector sector = sectores.get(i);
                        if (sector == mesa.getSector()){
                            for (int o=0;o<funcionarios.size();o++){
                                Funcionario funcionario = funcionarios.get(o);
                                if (funcionario == mesa.getFuncionario()){
                                    Mesa mesa1 = mesaRepository.save(mesa);
                                    return ResponseEntity.ok(mesa1);
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

    //Esta función actualiza los datos de una mesa en la base de datos
    @PutMapping("/mesa")
    public ResponseEntity<Mesa> update(@RequestBody Mesa mesa){
        try {
            List<Sector> sectores = sectorRepository.findAll();
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            List<Mesa> mesas = mesaRepository.findAll();
            for (int m =0; m<mesas.size();m++){
                Mesa me = mesas.get(m);
                if (me.getId_mesa() == mesa.getId_mesa()){
                    if (mesa.getCapacidad() >= 1){
                        for (int i=0;i<sectores.size();i++){
                            Sector sector = sectores.get(i);
                            if (sector == mesa.getSector()){
                                for (int o=0;o<funcionarios.size();o++){
                                    Funcionario funcionario = funcionarios.get(o);
                                    if (funcionario == mesa.getFuncionario()){
                                        Mesa mesa1 = mesaRepository.save(mesa);
                                        return ResponseEntity.ok(mesa1);
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

    //Esta función obtiene a las mesas que están disponibles
    @GetMapping("/mesas_disponibles")
    public List<Mesa> findByEstado(){
        try {
            List<Mesa> mesas = mesaRepository.findAll();
            List<Mesa> mesasD= new ArrayList<>();
            for (int i =0; i<mesas.size();i++){
                Mesa mesa = mesas.get(i);
                if (mesa.isEstado()){
                    mesasD.add(mesa);
                }
            }
            return mesasD;


        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }



}
