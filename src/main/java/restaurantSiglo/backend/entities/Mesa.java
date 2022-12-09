package restaurantSiglo.backend.entities;

import javax.persistence.*;

@Entity
public class Mesa {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mesa;
    private boolean estado;
    private Integer capacidad;
    @ManyToOne
    @JoinColumn(name = "id_sector")
    private Sector sector;
    private Integer grupo;
    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Funcionario funcionario;

    //Constructores
    public Mesa() {
    }

    public Mesa(Integer id_mesa, boolean estado, Integer capacidad, Sector sector, Integer grupo, Funcionario funcionario) {
        this.id_mesa = id_mesa;
        this.estado = estado;
        this.capacidad = capacidad;
        this.sector = sector;
        this.grupo = grupo;
        this.funcionario = funcionario;
    }

    //Getters y Setters

    public Integer getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Integer id_mesa) {
        this.id_mesa = id_mesa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
