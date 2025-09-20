package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posicion")
public class Posicion {

    @Id
    private Integer id;
    private String nombre;
    private Integer verticalHorizontal;
    private Integer idPosicionComun;
    private Integer idEscenario;

    // Constructor vacío
    public Posicion() {}

    // Constructor con parámetros
    public Posicion(Integer id, String nombre, Integer verticalHorizontal, Integer idPosicionComun, Integer idEscenario) {
        this.id = id;
        this.nombre = nombre;
        this.verticalHorizontal = verticalHorizontal;
        this.idPosicionComun = idPosicionComun;
        this.idEscenario = idEscenario;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVerticalHorizontal() {
        return verticalHorizontal;
    }

    public void setVerticalHorizontal(Integer verticalHorizontal) {
        this.verticalHorizontal = verticalHorizontal;
    }

    public Integer getIdPosicionComun() {
        return idPosicionComun;
    }

    public void setIdPosicionComun(Integer idPosicionComun) {
        this.idPosicionComun = idPosicionComun;
    }

    public Integer getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(Integer idEscenario) {
        this.idEscenario = idEscenario;
    }
}
