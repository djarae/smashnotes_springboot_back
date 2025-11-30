package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "ataque")
public class Ataque {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento")
    private Movimiento idMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_combo")
    private Combo idCombo;

    @Column(name = "tipo_ataque")
    private String tipoAtaque;

    @Column(name = "id_propiedad")
    private Integer idPropiedad;

    private String nombre;
    private String abreviatura;

    public Ataque() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movimiento getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Movimiento idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Combo getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(Combo idCombo) {
        this.idCombo = idCombo;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }

    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
