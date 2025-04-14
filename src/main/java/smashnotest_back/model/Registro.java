package smashnotest_back.model;

public class Registro {
    private int id;
    private int idPersonajeEmisor;
    private int idPersonajeReceptor;
    private int idMovimiento;
    private int idEscenario;
    private int idPosicion;
    private int rage;
    private int porcentajeKO;

    public Registro(
            int id,
            int idPersonajeEmisor,
            int idPersonajeReceptor,
            int idMovimiento,
            int idEscenario,
            int idPosicion,
            int rage,
            int porcentajeKO) {
        this.id = id;
        this.idPersonajeEmisor = idPersonajeEmisor;
        this.idPersonajeReceptor = idPersonajeReceptor;
        this.idMovimiento = idMovimiento;
        this.idEscenario = idEscenario;
        this.idPosicion = idPosicion;
        this.porcentajeKO = porcentajeKO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersonajeEmisor() {
        return idPersonajeEmisor;
    }

    public void setIdPersonajeEmisor(int idPersonajeEmisor) {
        this.idPersonajeEmisor = idPersonajeEmisor;
    }

    public int getIdPersonajeReceptor() {
        return idPersonajeReceptor;
    }

    public void setIdPersonajeReceptor(int idPersonajeReceptor) {
        this.idPersonajeReceptor = idPersonajeReceptor;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(int idEscenario) {
        this.idEscenario = idEscenario;
    }

    public int getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int porcentajeKO) {
        this.rage = rage;
    }

    public int getPorcentajeKO() {
        return porcentajeKO;
    }

    public void setPorcentajeKO(int porcentajeKO) {
        this.porcentajeKO = porcentajeKO;
    }
}
