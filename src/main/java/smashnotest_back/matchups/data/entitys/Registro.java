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

    // Solo guardamos IDs, no dependencias
    private Integer idEscenario;
    private Integer idMovimiento;
    private Integer idPersonajeEmisor;
    private Integer idPersonajeReceptor;
    private Integer idPosicion;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRage() { return rage; }
    public void setRage(int rage) { this.rage = rage; }

    public boolean getDi() { return di; }
    public void setDi(boolean di) { this.di = di; }

    public int getPorcentajeKO() { return porcentajeKO; }
    public void setPorcentajeKO(int porcentajeKO) { this.porcentajeKO = porcentajeKO; }

    public int getIdPersonajeEmisor() { return idPersonajeEmisor; }
    public void setIdPersonajeEmisor(int idPersonajeEmisor) { this.idPersonajeEmisor = idPersonajeEmisor; }

    public int getIdPersonajeReceptor() { return idPersonajeReceptor; }
    public void setIdPersonajeReceptor(int idPersonajeReceptor) { this.idPersonajeReceptor = idPersonajeReceptor; }

    public int getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(int idMovimiento) { this.idMovimiento = idMovimiento; }

    public int getIdEscenario() { return idEscenario; }
    public void setIdEscenario(int idEscenario) { this.idEscenario = idEscenario; }

    public int getIdPosicion() { return idPosicion; }
    public void setIdPosicion(int idPosicion) { this.idPosicion = idPosicion; }
}
