package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_personaje_emisor")
    private Personaje idPersonajeEmisor;

    @ManyToOne
    @JoinColumn(name = "id_personaje_receptor")
    private Personaje idPersonajeReceptor;

    @ManyToOne
    @JoinColumn(name = "id_movimiento")
    private Movimiento idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_escenario")
    private Escenario idEscenario;

    @ManyToOne
    @JoinColumn(name = "id_posicion")
    private Posicion idPosicion;

    private Integer rage;
    private Boolean di;
    private Integer porcentajeKO;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Personaje getIdPersonajeEmisor() { return idPersonajeEmisor; }
    public void setIdPersonajeEmisor(Personaje idPersonajeEmisor) { this.idPersonajeEmisor = idPersonajeEmisor; }

    public Personaje getIdPersonajeReceptor() { return idPersonajeReceptor; }
    public void setIdPersonajeReceptor(Personaje idPersonajeReceptor) { this.idPersonajeReceptor = idPersonajeReceptor; }

    public Movimiento getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(Movimiento idMovimiento) { this.idMovimiento = idMovimiento; }

    public Escenario getIdEscenario() { return idEscenario; }
    public void setIdEscenario(Escenario idEscenario) { this.idEscenario = idEscenario; }

    public Posicion getIdPosicion() { return idPosicion; }
    public void setIdPosicion(Posicion idPosicion) { this.idPosicion = idPosicion; }

    public Integer getRage() { return rage; }
    public void setRage(Integer rage) { this.rage = rage; }

    public Boolean getDi() { return di; }
    public void setDi(Boolean di) { this.di = di; }

    public Integer getPorcentajeKO() { return porcentajeKO; }
    public void setPorcentajeKO(Integer porcentajeKO) { this.porcentajeKO = porcentajeKO; }
}
