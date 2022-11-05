package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Medida {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_medida;
    private String descripcion;

    //Constructores
    public Tipo_Medida() {
    }

    public Tipo_Medida(Integer id_tipo_medida, String descripcion) {
        this.id_tipo_medida = id_tipo_medida;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public Integer getId_tipo_medida() {
        return id_tipo_medida;
    }

    public void setId_tipo_medida(Integer id_tipo_medida) {
        this.id_tipo_medida = id_tipo_medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
