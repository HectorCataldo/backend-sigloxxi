package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Funcionario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_funcionario;
    private String descripcion;

    //Constructores
    public Tipo_Funcionario() {
    }

    public Tipo_Funcionario(Integer id_tipo_funcionario, String descripcion) {
        this.id_tipo_funcionario = id_tipo_funcionario;
        this.descripcion = descripcion;
    }

    //Getters y Setters

    public Integer getId_tipo_funcionario() {
        return id_tipo_funcionario;
    }

    public void setId_tipo_funcionario(Integer id_tipo_funcionario) {
        this.id_tipo_funcionario = id_tipo_funcionario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
