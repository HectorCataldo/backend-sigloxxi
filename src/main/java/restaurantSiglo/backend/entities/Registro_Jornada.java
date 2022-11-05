package restaurantSiglo.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Registro_Jornada {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_registro;
    private Date fecha;      //QUE TIPO DE DATE PUEDE SER MEJOR PARA LOS SIGUIENTES CASOS¿?
    private Date hora_entrada;
    private Date hora_salida;
    @ManyToOne
    @JoinColumn(name = "funcionario_id_funcionario")
    private Funcionario funcionario;

    //Constructores

    public Registro_Jornada() {
    }

    public Registro_Jornada(Integer id_registro, Date fecha, Date hora_entrada, Date hora_salida, Funcionario funcionario) {
        this.id_registro = id_registro;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.funcionario = funcionario;
    }
    //Getters y Setters


    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
