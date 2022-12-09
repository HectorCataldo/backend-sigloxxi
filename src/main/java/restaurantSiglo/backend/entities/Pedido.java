package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Pedido {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Receta receta;
    private String descripcion;

    private Integer estado_pedido = 1;

    //Constructores

    public Pedido() {
    }

    public Pedido(Integer id_pedido, Mesa mesa, Receta receta, String descripcion, Integer estado_pedido) {
        this.id_pedido = id_pedido;
        this.mesa = mesa;
        this.receta = receta;
        this.descripcion = descripcion;
        this.estado_pedido = estado_pedido;
    }
//Getters y Setters

    public Integer getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(Integer estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
