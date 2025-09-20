package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "escenario")
public class Escenario {

    @Id
    private Integer id;
    private String nombre;

    // Constructor vacío
    public Escenario() {}

    // Constructor con parámetros
    public Escenario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
