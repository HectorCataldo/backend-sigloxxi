package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Funcionario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_funcionario")
    private Tipo_Funcionario tipo_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_registro")
    private Registro_Jornada registro_jornada;



    //Constructores

    public Funcionario() {
    }

    public Funcionario(Integer id_funcionario, Persona persona, Tipo_Funcionario tipo_funcionario, Registro_Jornada registro_jornada) {
        this.id_funcionario = id_funcionario;
        this.persona = persona;
        this.tipo_funcionario = tipo_funcionario;
        this.registro_jornada = registro_jornada;
    }
    //Getter y Setters
    public Registro_Jornada getRegistro_jornada() {
        return registro_jornada;
    }

    public void setRegistro_jornada(Registro_Jornada registro_jornada) {
        this.registro_jornada = registro_jornada;
    }
    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Tipo_Funcionario getTipo_funcionario() {
        return tipo_funcionario;
    }

    public void setTipo_funcionario(Tipo_Funcionario tipo_funcionario) {
        this.tipo_funcionario = tipo_funcionario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
