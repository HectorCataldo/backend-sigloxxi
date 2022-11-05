package restaurantSiglo.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alerta;
    private String descripcion;
    private char estado;
    private Integer dias;

    public Alerta() {
    }

    public Alerta(Integer id_alerta, String descripcion, char estado, Integer dias) {
        this.id_alerta = id_alerta;
        this.descripcion = descripcion;
        this.estado = estado;
        this.dias = dias;
    }

    public Integer getId_alerta() {
        return id_alerta;
    }

    public void setId_alerta(Integer id_alerta) {
        this.id_alerta = id_alerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
}
