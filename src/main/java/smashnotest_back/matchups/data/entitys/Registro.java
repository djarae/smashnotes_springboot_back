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
    public void setIdEscenario(Escenario idEscenario) {
        this.idEscenario = idEscenario;
    }

    public Posicion getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Posicion idPosicion) {
        this.idPosicion = idPosicion;
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
