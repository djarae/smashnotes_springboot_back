package smashnotest_back.dtos;

public interface RegistroDTO {
    Long getId();

    Long getIdPersonajeEmisor();
    String getNombrePersonajeEmisor();
    String getAbreviaturaEmisor();

    Long getIdPersonajeReceptor();
    String getNombrePersonajeReceptor();
    String getAbreviaturaReceptor();

    Long getIdMovimiento();
    String getNombreMovimiento();
    String getAbreviaturaMovimiento();

    Long getIdEscenario();
    String getNombreEscenario();
    String getAbreviaturaEscenario();

    Long getIdPosicion();
    String getNombrePosicion();

    Integer getRage();
    Boolean getDi();
    Integer getPorcentajeKO();
}
