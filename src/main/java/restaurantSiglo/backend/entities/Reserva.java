package restaurantSiglo.backend.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Reserva {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private Date fecha;
    private Date hora;
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    //Constructores

    public Reserva() {
    }

    public Reserva(Integer id_reserva, Persona persona, Date fecha, Date hora, Mesa mesa) {
        this.id_reserva = id_reserva;
        this.persona = persona;
        this.fecha = fecha;
        this.hora = hora;
        this.mesa = mesa;
    }
    //Getters y Setters


    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
