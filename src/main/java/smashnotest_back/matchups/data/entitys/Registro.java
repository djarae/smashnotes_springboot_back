package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personaje_emisor", nullable = false)
    private Personaje idPersonajeEmisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personaje_receptor", nullable = false)
    private Personaje idPersonajeReceptor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento", nullable = false)
    private Movimiento idMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escenario", nullable = false)
    private Escenario idEscenario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_posicion", nullable = false)
    private Posicion idPosicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ataque")
    private Ataque idAtaque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_combo")
    private Combo idCombo;

    @Column(name = "rage", nullable = false)
    private Integer rage = 0;

    @Column(name = "di", nullable = false)
    private Boolean di = Boolean.FALSE;

    @Column(name = "porcentaje_ko", nullable = false)
    private Integer porcentajeKO = 0;

    // ---------------- Getters & Setters ----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getIdPersonajeEmisor() {
        return idPersonajeEmisor;
    }

    public void setIdPersonajeEmisor(Personaje idPersonajeEmisor) {
        this.idPersonajeEmisor = idPersonajeEmisor;
    }

    public Personaje getIdPersonajeReceptor() {
        return idPersonajeReceptor;
    }

    public void setIdPersonajeReceptor(Personaje idPersonajeReceptor) {
        this.idPersonajeReceptor = idPersonajeReceptor;
    }

    public Movimiento getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Movimiento idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Escenario getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(Escenario idEscenario) {
        this.idEscenario = idEscenario;
    }

    public Posicion getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Posicion idPosicion) {
        this.idPosicion = idPosicion;
    }

    public Ataque getIdAtaque() {
        return idAtaque;
    }

    public void setIdAtaque(Ataque idAtaque) {
        this.idAtaque = idAtaque;
    }

    public Combo getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(Combo idCombo) {
        this.idCombo = idCombo;
    }

    public Integer getRage() {
        return rage;
    }

    public void setRage(Integer rage) {
        this.rage = rage;
    }

    public Boolean getDi() {
        return di;
    }

    public void setDi(Boolean di) {
        this.di = di;
    }

    public Integer getPorcentajeKO() {
        return porcentajeKO;
    }

    public void setPorcentajeKO(Integer porcentajeKO) {
        this.porcentajeKO = porcentajeKO;
    }
}
