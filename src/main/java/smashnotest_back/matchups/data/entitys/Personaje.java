package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    private Integer id;
    private Integer echo;
    private String nombre;

    // Constructor vacío
    public Personaje() {}

    // Constructor con parámetros
    public Personaje(Integer id, Integer echo, String nombre) {
        this.id = id;
        this.echo = echo;
        this.nombre = nombre;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEcho() {
        return echo;
    }

    public void setEcho(Integer echo) {
        this.echo = echo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
