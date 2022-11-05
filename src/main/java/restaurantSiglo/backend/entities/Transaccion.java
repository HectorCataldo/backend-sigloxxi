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
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "tipo_transaccion_id_tipo_transaccion")
    private Tipo_Transaccion tipo_transaccion;

    //Constructores

    public Transaccion() {
    }

    public Transaccion(Integer id_transaccion, Integer valor, Integer cantidad, Producto producto, Tipo_Transaccion tipo_transaccion) {
        this.id_transaccion = id_transaccion;
        this.valor = valor;
        this.cantidad = cantidad;
        this.producto = producto;
        this.tipo_transaccion = tipo_transaccion;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
