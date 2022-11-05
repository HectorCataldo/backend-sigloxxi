package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sector {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sector;
    private  boolean estado;
    private String descripcion;

    //Constructor
    public Sector() {
    }

    public Sector(Integer id_sector, boolean estado, String descripcion) {
        this.id_sector = id_sector;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    //Getters y Setters

    public Integer getId_sector() {
        return id_sector;
    }

    public void setId_sector(Integer id_sector) {
        this.id_sector = id_sector;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
