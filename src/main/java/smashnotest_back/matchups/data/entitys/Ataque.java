package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ataque")
public class Ataque {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Movimiento idMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_combo")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Combo idCombo;

    @Column(name = "tipo_ataque")
    private String tipoAtaque;

    @Column(name = "eje")
    private String eje; // puede ser "vertical" u "horizontal"

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

    public String getEje() {
        return eje;
    }

    public void setEje(String eje) {
        this.eje = eje;
    }

}
