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
    private String eje; // puede ser "vertical" u "horizontal"
    private String abreviatura;

    public Posicion() {
    }

    public Posicion(Integer id, String nombre, String eje, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.eje = eje;
        this.abreviatura = abreviatura;
    }

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

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
