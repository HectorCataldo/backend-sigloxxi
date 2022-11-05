package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Producto {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_producto;
    private String descripcion;

    //Constructores
    public Tipo_Producto() {
    }

    public Tipo_Producto(Integer id_tipo_producto, String descripcion) {
        this.id_tipo_producto = id_tipo_producto;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public Integer getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(Integer id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
