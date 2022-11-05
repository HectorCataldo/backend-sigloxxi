package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Transaccion {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_transaccion;
    private String descripcion;

    //Constructores
    public Tipo_Transaccion() {
    }

    public Tipo_Transaccion(Integer id_tipo_transaccion, String descripcion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
        this.descripcion = descripcion;
    }

    //Getters y Setters

    public Integer getId_tipo_transaccion() {
        return id_tipo_transaccion;
    }

    public void setId_tipo_transaccion(Integer id_tipo_transaccion) {
        this.id_tipo_transaccion = id_tipo_transaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
