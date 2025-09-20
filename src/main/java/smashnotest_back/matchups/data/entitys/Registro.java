package smashnotest_back.matchups.data.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o SEQUENCE si lo tienes así
    private int id;

    @Column(name = "idPersonajeEmisor")
    private int idPersonajeEmisor;

    @Column(name = "idPersonajeReceptor")
    private int idPersonajeReceptor;

    @Column(name = "idMovimiento")
    private int idMovimiento;

    @Column(name = "idEscenario")
    private int idEscenario;

    @Column(name = "idPosicion")
    private int idPosicion;

    private int rage;

    private boolean di;

    @Column(name = "porcentajeKO")
    private int porcentajeKO;

    // 👉 Constructor vacío requerido por JPA
    public Registro() {}

    // Constructor completo
    public Registro(int id, int idPersonajeEmisor, int idPersonajeReceptor,
                    int idMovimiento, int idEscenario, int idPosicion,
                    int rage, boolean di, int porcentajeKO) {
        this.id = id;
        this.idPersonajeEmisor = idPersonajeEmisor;
        this.idPersonajeReceptor = idPersonajeReceptor;
        this.idMovimiento = idMovimiento;
        this.idEscenario = idEscenario;
        this.idPosicion = idPosicion;
        this.rage = rage;
        this.di = di;
        this.porcentajeKO = porcentajeKO;
    }

    // getters y setters...
}
