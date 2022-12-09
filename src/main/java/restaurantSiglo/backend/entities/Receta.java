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
    @JoinColumn(name = "id_tipo_receta")
    private Tipo_Receta tipo_receta;
    private String imagen;
    private String nombre;
    private Integer precio;
    @ManyToOne
    @JoinColumn(name = "id_producto_bodega")
    private Bodega_Cocina bodega_cocina;

    //Constructores

    public Receta() {
    }

    public Receta(Integer id_receta, String descripcion, Integer cantidad, Tipo_Receta tipo_receta, String imagen, String nombre, Integer precio, Bodega_Cocina bodega_cocina) {
        this.id_receta = id_receta;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo_receta = tipo_receta;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.bodega_cocina = bodega_cocina;
    }

    //Getters y setters


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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Bodega_Cocina getBodega_cocina() {
        return bodega_cocina;
    }

    public void setBodega_cocina(Bodega_Cocina bodega_cocina) {
        this.bodega_cocina = bodega_cocina;
    }

    public Tipo_Receta getTipo_receta() {
        return tipo_receta;
    }

    public void setTipo_receta(Tipo_Receta tipo_receta) {
        this.tipo_receta = tipo_receta;
    }
}
