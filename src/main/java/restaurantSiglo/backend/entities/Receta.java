package restaurantSiglo.backend.entities;


import javax.persistence.*;

@Entity
public class Receta {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_receta;
    private String descripcion;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "tipo_receta_id_tipo_receta")
    private Tipo_Receta tipo_receta;

    //private Bodega_Cocina bodega_cocina_id_prodcuto;

    //Constructores

    public Receta() {
    }

    public Receta(Integer id_receta, String descripcion, Integer cantidad, Producto producto, Tipo_Receta tipo_receta) {
        this.id_receta = id_receta;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.producto = producto;
        this.tipo_receta = tipo_receta;
    }
    //Getters y Setters


    public Integer getId_receta() {
        return id_receta;
    }

    public void setId_receta(Integer id_receta) {
        this.id_receta = id_receta;
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
}
