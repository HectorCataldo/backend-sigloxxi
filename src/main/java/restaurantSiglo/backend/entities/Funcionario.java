package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Funcionario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcionario;

    @ManyToOne
    @JoinColumn(name = "persona_id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "tipo_funcionario_id_tipo_funcionario")
    private Tipo_Funcionario tipo_funcionario;

    //Constructores

    public Funcionario() {
    }

    public Funcionario(Integer id_funcionario, Persona persona, Tipo_Funcionario tipo_funcionario) {
        this.id_funcionario = id_funcionario;
        this.persona = persona;
        this.tipo_funcionario = tipo_funcionario;
    }
    //Getter y Setters

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
