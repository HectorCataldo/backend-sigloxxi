package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Tipo_Funcionario;
import restaurantSiglo.backend.repository.Tipo_FuncionarioRepository;

import java.util.List;

@RestController
public class TipoFuncionarioController {

    //Obtenemos el Respositorio
    private Tipo_FuncionarioRepository tipo_funcionarioRepository;

    //Creamos el Constructor
    public TipoFuncionarioController(Tipo_FuncionarioRepository tipo_funcionarioRepository) {
        this.tipo_funcionarioRepository = tipo_funcionarioRepository;
    }

    //Esta función busca todos los tipos de funcionario en la base de datos
    @GetMapping("/tipos_funcionarios")
    public List<Tipo_Funcionario> findAll(){
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        return tipo_funcionarios;
    }

    //Esta función busca a un tipo de funcionario por Id dentro de la base de datos
    @GetMapping("/tipos_funcionarios/{id}")
    public ResponseEntity<Tipo_Funcionario> findById(@PathVariable Integer id){
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        for (int i=0; i < tipo_funcionarios.size(); i++){
            Tipo_Funcionario tipo_funcionario = tipo_funcionarios.get(i);
            if (tipo_funcionario.getId_tipo_funcionario() == id){
                return ResponseEntity.ok(tipo_funcionarios.get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina un tipo de funcionario de la base de datos
    @DeleteMapping("/tipos_funcionarios/{id}")
    public ResponseEntity<Tipo_Funcionario> delete(@PathVariable Integer id){
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        for (int i=0; i < tipo_funcionarios.size(); i++){
            Tipo_Funcionario tipo_funcionario = tipo_funcionarios.get(i);
            if (tipo_funcionario.getId_tipo_funcionario() == id){
                tipo_funcionarioRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un tipo de funcionario en base de datos
    @PostMapping("/tipos_funcionarios")
    public ResponseEntity<Tipo_Funcionario> create(@RequestBody Tipo_Funcionario tipo_funcionario){
        if (tipo_funcionario.getId_tipo_funcionario() == null){
            Tipo_Funcionario tf1 = tipo_funcionarioRepository.save(tipo_funcionario);
            return ResponseEntity.ok(tf1);
        }
        return  ResponseEntity.badRequest().build();
    }

    //Esta función actualiza los datos de un tipo de funcionario en base de datos
    @PutMapping("/tipos_funcionarios")
    public ResponseEntity<Tipo_Funcionario> update(@RequestBody Tipo_Funcionario tipo_funcionario){
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        for (int i = 0; i<tipo_funcionarios.size(); i++){
            Tipo_Funcionario tf1 = tipo_funcionarios.get(i);
            if (tf1.getId_tipo_funcionario()== tipo_funcionario.getId_tipo_funcionario()){
                Tipo_Funcionario tf = tipo_funcionarioRepository.save(tipo_funcionario);
                return ResponseEntity.ok(tf);
            }
        }
        return  ResponseEntity.badRequest().build();
    }



}
