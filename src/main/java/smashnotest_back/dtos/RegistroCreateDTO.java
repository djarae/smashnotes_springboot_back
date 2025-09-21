package smashnotest_back.dtos;

public class RegistroCreateDTO {
    public Integer idPersonajeEmisor;
    public Integer idPersonajeReceptor;
    public Integer idEscenario;
    public Integer idMovimiento;
    public Integer idPosicion;
    public Integer rage;
    public Boolean di;          // 👈 ahora Boolean, no Integer
    public Integer porcentajeKO;
}
