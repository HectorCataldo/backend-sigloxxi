package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Transaccion {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaccion;
    private Integer valor;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_transaccion")
    private Tipo_Transaccion tipo_transaccion;
    @ManyToOne
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedido;



    //Constructores

    public Transaccion() {
    }

    public Transaccion(Integer id_transaccion, Integer valor, Integer cantidad, Tipo_Transaccion tipo_transaccion,Pedido pedido) {
        this.id_transaccion = id_transaccion;
        this.valor = valor;
        this.cantidad = cantidad;
        this.tipo_transaccion = tipo_transaccion;
        this.pedido = pedido;
    }
    //Getters y Setters

    public Integer getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Tipo_Transaccion getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(Tipo_Transaccion tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
