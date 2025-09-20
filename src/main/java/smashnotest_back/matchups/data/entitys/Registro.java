package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rage;
    private boolean di;
    private int porcentajeKO;

    private Integer idEscenario;
    private Integer idMovimiento;
    private Integer idPersonajeEmisor;
    private Integer idPersonajeReceptor;
    private Integer idPosicion;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRage() { return rage; }
    public void setRage(int rage) { this.rage = rage; }

    public boolean getDi() { return di; }
    public void setDi(boolean di) { this.di = di; }

    public int getPorcentajeKO() { return porcentajeKO; }
    public void setPorcentajeKO(int porcentajeKO) { this.porcentajeKO = porcentajeKO; }

    public Integer getIdEscenario() { return idEscenario; }
    public void setIdEscenario(Integer idEscenario) { this.idEscenario = idEscenario; }

    public Integer getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(Integer idMovimiento) { this.idMovimiento = idMovimiento; }

    public Integer getIdPersonajeEmisor() { return idPersonajeEmisor; }
    public void setIdPersonajeEmisor(Integer idPersonajeEmisor) { this.idPersonajeEmisor = idPersonajeEmisor; }

    public Integer getIdPersonajeReceptor() { return idPersonajeReceptor; }
    public void setIdPersonajeReceptor(Integer idPersonajeReceptor) { this.idPersonajeReceptor = idPersonajeReceptor; }

    public Integer getIdPosicion() { return idPosicion; }
    public void setIdPosicion(Integer idPosicion) { this.idPosicion = idPosicion; }
}
