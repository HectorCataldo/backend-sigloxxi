package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Bodega_Cocina {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_producto_bodega;
    private String descripcion;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "id_alerta")
    private Alerta alerta;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    //Constructores

    public Bodega_Cocina() {
    }

    public Bodega_Cocina(Integer id_producto_bodega, String descripcion, Integer cantidad, Alerta alerta, Producto producto) {
        this.id_producto_bodega = id_producto_bodega;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.alerta = alerta;
        this.producto = producto;
    }

    //Getter y setters

    public Integer getId_producto_bodega() {
        return id_producto_bodega;
    }

    public void setId_producto_bodega(Integer id_producto_bodega) {
        this.id_producto_bodega = id_producto_bodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
}
