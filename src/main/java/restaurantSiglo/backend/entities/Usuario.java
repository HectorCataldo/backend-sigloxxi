package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    private String contrasena;

    //Constructores

    public Usuario() {
    }

    public Usuario(Integer id_usuario, Funcionario funcionario, String contrasena) {
        this.id_usuario = id_usuario;
        this.funcionario = funcionario;
        this.contrasena = contrasena;
    }
    //Getters y Setters

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
