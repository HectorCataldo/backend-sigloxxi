package restaurantSiglo.backend.controller;

import com.sun.jdi.event.ExceptionEvent;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantSiglo.backend.entities.Funcionario;
import restaurantSiglo.backend.entities.Persona;
import restaurantSiglo.backend.entities.Usuario;
import restaurantSiglo.backend.repository.FuncionarioRepository;
import restaurantSiglo.backend.repository.PersonaRepository;
import restaurantSiglo.backend.repository.UsuarioRepository;

import java.util.List;

@RestController
public class UsuarioController {

    //Obtenemos los repositorios
    private UsuarioRepository usuarioRepository;
    private FuncionarioRepository funcionarioRepository;
    private PersonaRepository personaRepository;

    //Creamos el constructor


    public UsuarioController(UsuarioRepository usuarioRepository, FuncionarioRepository funcionarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.personaRepository = personaRepository;
    }

    //Esta función obtiene a todos los usuarios de la base de datos
    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return usuarios;
        }
        catch (Exception e){
            e.getCause();
        }
        return null;
    }

    //Esta función obtiene a un usuario por id de la base de dato
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> findById (@PathVariable Integer id){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            for (int i =0;i<usuarios.size();i++){
                Usuario usuario = usuarios.get(i);
                if (usuario.getId_usuario() == id){
                    return ResponseEntity.ok(usuario);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función obtiene a un usuario por su correo dentro de la base de datos
    @GetMapping("/usuario/{correo}")
    public ResponseEntity<Usuario> findByUser(@PathVariable String correo){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            for (int i =0;i<usuarios.size();i++){
                Usuario usuario = usuarios.get(i);
                if (usuario.getFuncionario().getPersona().getCorreo().equals(correo)){
                    return ResponseEntity.ok(usuario);
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función elimina a un usuario por su id dentro de la base de datos
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario>delete(@PathVariable Integer id){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            for (int i =0;i<usuarios.size();i++){
                Usuario usuario = usuarios.get(i);
                if (usuario.getId_usuario() == id){
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }
            }
        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }

    //Esta función crea a un usuario en la base de datos
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        try {
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            if (usuario.getId_usuario() == null){
                for (int i=0;i<funcionarios.size();i++){
                    Funcionario funcionario = funcionarios.get(i);
                    if (funcionario == usuario.getFuncionario()){
                        if (!usuario.getContrasena().isBlank()){
                            Usuario usuario1 = usuarioRepository.save(usuario);
                            return ResponseEntity.ok(usuario1);
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

    //Esta función actualiza los datos de un usuario en la base de datos
    @PutMapping("/usuarios")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, String correo){
        try {
            List<Usuario>usuarios =usuarioRepository.findAll();
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            for (int o =0; o<usuarios.size();o++){
                Usuario usuario1 = usuarios.get(o);
                if (usuario1.getId_usuario()== usuario.getId_usuario()){
                    for (int i=0;i<funcionarios.size();i++){
                        Funcionario funcionario = funcionarios.get(i);
                        if (funcionario == usuario.getFuncionario()){
                            if (!usuario.getContrasena().isBlank()){
                                Usuario usuario2 = usuarioRepository.save(usuario);
                                Persona persona = usuario.getFuncionario().getPersona();
                                persona.setCorreo(correo);
                                personaRepository.save(persona);
                                return ResponseEntity.ok(usuario2);
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

    //Esta función valida las credenciales de un usuario con correo y contraseña correctas guardados en Base de datos
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarUsuario(String correo, String contrasena){
        try {
            List<Usuario>usuarios =usuarioRepository.findAll();
            for (int i=0; i<usuarios.size();i++){
                Usuario usuario = usuarios.get(i);
                if (usuario.getFuncionario().getPersona().getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)){
                    return ResponseEntity.ok(usuario);
                }
            }

        }
        catch (Exception e){
            e.getCause();
        }
        return ResponseEntity.notFound().build();
    }
}
