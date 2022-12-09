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

    //Constructores

    public Pedido() {
    }

    public Pedido(Integer id_pedido, Mesa mesa, Receta receta, String descripcion) {
        this.id_pedido = id_pedido;
        this.mesa = mesa;
        this.receta = receta;
        this.descripcion = descripcion;
    }
    //Getters y Setters

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
