package restaurantSiglo.backend.entities;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    private String descripcion;

    //Constructores

    public  Proveedor(){

    }
    public Proveedor(Integer id_proveedor,String descripcion){
        this.id_proveedor = id_proveedor;
        this.descripcion = descripcion;
    }

    //Getters y Setters

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
