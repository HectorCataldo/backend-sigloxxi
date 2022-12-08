package restaurantSiglo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Funcionario;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.entities.Registro_Jornada;
import restaurantSiglo.backend.entities.Tipo_Funcionario;
import restaurantSiglo.backend.repository.FuncionarioRepository;
import restaurantSiglo.backend.repository.PersonaRepository;
import restaurantSiglo.backend.repository.Registro_JornadaRepository;
import restaurantSiglo.backend.repository.Tipo_FuncionarioRepository;

import java.util.List;

@RestController
public class FuncionarioController {

    //Obtenemos los repositorios
    private FuncionarioRepository funcionarioRepository;
    private PersonaRepository personaRepository;
    private Tipo_FuncionarioRepository tipo_funcionarioRepository;
    private Registro_JornadaRepository registro_jornadaRepository;

    //Creamos el constructor
    public FuncionarioController(FuncionarioRepository funcionarioRepository, PersonaRepository personaRepository, Tipo_FuncionarioRepository tipo_funcionarioRepository,Registro_JornadaRepository registro_jornadaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.personaRepository = personaRepository;
        this.tipo_funcionarioRepository = tipo_funcionarioRepository;
        this.registro_jornadaRepository = registro_jornadaRepository;
    }

    //Esta función busca y obtiene a todos los funcionarios en la base de datos
    @GetMapping("/funcionarios")
    public List<Funcionario> findAll(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    //Esta función busca y obtiene a un funcionario por Id en la base de datos
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        for (int i = 0; i< funcionarios.size(); i++){
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getId_funcionario() == id){
                return ResponseEntity.ok(funcionario);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un funcionario por Id de la base de datos
    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> delete(@PathVariable Integer id){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        for (int i = 0; i< funcionarios.size(); i++){
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getId_funcionario()== id){
                funcionarioRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea un funcionario dentro de la base de datos
    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        List<Persona> personas = personaRepository.findAll();
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        if (funcionario.getId_funcionario() == null){
            for (int i =0; i<personas.size();i++){
                Persona p = personas.get(i);
                if(p == funcionario.getPersona()){
                    for (int l =0; l< tipo_funcionarios.size(); l++){
                        Tipo_Funcionario tp = tipo_funcionarios.get(l);
                        if (tp == funcionario.getTipo_funcionario()){
                            for (int k = 0; k<registro_jornadas.size(); k++){
                                Registro_Jornada registro_jornada = registro_jornadas.get(k);
                                if (registro_jornada == funcionario.getRegistro_jornada()){
                                    Funcionario f = funcionarioRepository.save(funcionario);
                                    return ResponseEntity.ok(f);
                                }
                            }

                        }
                    }
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/funcionarios")
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario) {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        List<Persona> personas = personaRepository.findAll();
        List<Tipo_Funcionario> tipo_funcionarios = tipo_funcionarioRepository.findAll();
        List<Registro_Jornada> registro_jornadas = registro_jornadaRepository.findAll();
        for(int i = 0; i<funcionarios.size();i++){
            Funcionario f = funcionarios.get(i);
            if (f.getId_funcionario() == funcionario.getId_funcionario()){
                for (int o = 0; 0<personas.size();o++){
                    Persona p = personas.get(o);
                    if (p == funcionario.getPersona()) {
                        for (int k = 0; k<tipo_funcionarios.size(); k++){
                            Tipo_Funcionario tp = tipo_funcionarios.get(k);
                            if (tp == funcionario.getTipo_funcionario()){
                                for (int l =0; l< registro_jornadas.size(); l++){
                                    Registro_Jornada registro_jornada = registro_jornadas.get(l);
                                    if (registro_jornada == funcionario.getRegistro_jornada()){
                                        Funcionario funcionario1 = funcionarioRepository.save(funcionario);
                                        return ResponseEntity.ok(funcionario1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ResponseEntity.notFound().build();
    }
}
