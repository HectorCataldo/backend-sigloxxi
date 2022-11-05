package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Orden_de_Compra {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_orden_de_compra;
    private Integer numero_orden;
    private Integer valor_total;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "proveedor_id_proveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;

    //Constructores

    public Orden_de_Compra() {
    }

    public Orden_de_Compra(Integer id_orden_de_compra, Integer numero_orden, Integer valor_total, Integer cantidad, Proveedor proveedor, Producto producto) {
        this.id_orden_de_compra = id_orden_de_compra;
        this.numero_orden = numero_orden;
        this.valor_total = valor_total;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.producto = producto;
    }
//Getters y Setters

    public Integer getId_orden_de_compra() {
        return id_orden_de_compra;
    }

    public void setId_orden_de_compra(Integer id_orden_de_compra) {
        this.id_orden_de_compra = id_orden_de_compra;
    }

    public Integer getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(Integer numero_orden) {
        this.numero_orden = numero_orden;
    }

    public Integer getValor_total() {
        return valor_total;
    }

    public void setValor_total(Integer valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
