package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimiento") // Nombre de la tabla en BD (puede ser "movimiento" si quieres)
public class Movimiento {

    @Id
    private Integer id;
    private String nombre;
    private String abreviatura;

    // Constructor vacío
    public Movimiento() {}

    // Constructor con parámetros
    public Movimiento(Integer id, String nombre, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAbreviatura() { return abreviatura; }
    public void setAbreviatura(String abreviatura) { this.abreviatura = abreviatura; }
}
