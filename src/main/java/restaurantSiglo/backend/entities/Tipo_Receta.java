package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Receta {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_receta;
    private String descripcion;

    //Constructores
    public Tipo_Receta(){

    }

    public Tipo_Receta(Integer id_tipo_receta, String descripcion){
        this.id_tipo_receta = id_tipo_receta;
        this.descripcion = descripcion;
    }


    //Getters y Setters
    public Integer getId_tipo_receta() {
        return id_tipo_receta;
    }

    public void setId_tipo_receta(Integer id_tipo_receta) {
        this.id_tipo_receta = id_tipo_receta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
