package restaurantSiglo.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Documento_Venta {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_documento_venta;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "tipo_receta_id_tipo_receta")
    private Tipo_Receta tipo_receta;
    private Integer valor_total;

    //Constructores


    public Documento_Venta() {
    }

    public Documento_Venta(Integer id_documento_venta, Date fecha, Pedido pedido, Producto producto, Integer cantidad, Tipo_Receta tipo_receta, Integer valor_total) {
        this.id_documento_venta = id_documento_venta;
        this.fecha = fecha;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipo_receta = tipo_receta;
        this.valor_total = valor_total;
    }

    //Getters y Setters

    public Integer getId_documento_venta() {
        return id_documento_venta;
    }

    public void setId_documento_venta(Integer id_documento_venta) {
        this.id_documento_venta = id_documento_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValor_total() {
        return valor_total;
    }

    public void setValor_total(Integer valor_total) {
        this.valor_total = valor_total;
    }

    public Tipo_Receta getTipo_receta() {
        return tipo_receta;
    }

    public void setTipo_receta(Tipo_Receta tipo_receta) {
        this.tipo_receta = tipo_receta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
