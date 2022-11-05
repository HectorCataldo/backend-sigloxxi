package restaurantSiglo.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Producto {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private String descripcion;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "tipo_medida_id_tipo_medida")
    private Tipo_Medida tipo_medida;
    @ManyToOne
    @JoinColumn(name = "tipo_producto_id_tipo_producto")
    private Tipo_Producto tipo_producto;
    @ManyToOne
    @JoinColumn(name = "proveedor_id_proveedor")
    private Proveedor proveedor;
    private Date fecha_vencimiento;
    @ManyToOne
    @JoinColumn(name = "alerta_id_alerta")
    private Alerta alerta;

    // Constructores

    public Producto() {
    }

    public Producto(Integer id_producto, String descripcion, Integer cantidad, Tipo_Medida tipo_medida, Tipo_Producto tipo_producto, Proveedor proveedor, Date fecha_vencimiento, Alerta alerta) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo_medida = tipo_medida;
        this.tipo_producto = tipo_producto;
        this.proveedor = proveedor;
        this.fecha_vencimiento = fecha_vencimiento;
        this.alerta = alerta;
    }
    //Getters y Setters


    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
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

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Tipo_Producto getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(Tipo_Producto tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public Tipo_Medida getTipo_medida() {
        return tipo_medida;
    }

    public void setTipo_medida(Tipo_Medida tipo_medida) {
        this.tipo_medida = tipo_medida;
    }


}
