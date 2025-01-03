package smashnotest_back;
public class Registro
{
    private int id;
    private int idPersonajeEmisor;
    private String nombrePersonajeEmisor;
    private int idPersonajeReceptor;
    private String nombrePersonajeReceptor;
    private int idMovimiento;
    private String nombreMovimiento;
    private String nombreEscenario;
    private int idPosicionEscenario;
    private String nombrePosicionEscenario;
    private int porcentajeKO;

    //Esta clase deberia tener mas data por el uso de JOIN para el listado de registros
    public Registro(
            int id,
            int idPersonajeEmisor,
            String nombrePersonajeEmisor,
            int idPersonajeReceptor,
            String nombrePersonajeReceptor,
            int idMovimiento,
            String nombreMovimiento,
            String nombreEscenario,
            int idPosicionEscenario,
            String nombrePosicionEscenario,
            int porcentajeKO)

    {
                super();
                this.id=id;
                this.idPersonajeEmisor=idPersonajeEmisor;
                this.nombrePersonajeEmisor=nombrePersonajeEmisor;
                this.idPersonajeReceptor=idPersonajeReceptor;
                this.nombrePersonajeReceptor=nombrePersonajeReceptor;
                this.idMovimiento=idMovimiento;
                this.nombreMovimiento=nombreMovimiento;
                this.nombreEscenario=nombreEscenario;
                this.idPosicionEscenario=idPosicionEscenario;
                this.nombrePosicionEscenario=nombrePosicionEscenario;
                this.porcentajeKO=porcentajeKO;}

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getIdPersonajeEmisor(){
        return idPersonajeEmisor;
    }
    public void setIdPersonajeEmisor(int idPersonajeReceptor){
        this.idPersonajeReceptor=idPersonajeReceptor;
    }
    public String getNombrePersonajeEmisor(){
        return nombrePersonajeEmisor;
    }
    public void setNombrePersonajeEmisor(String nombrePersonajeEmisor){
        this.nombrePersonajeEmisor=nombrePersonajeEmisor;
    }
    public int getIdPersonajeReceptor(){
        return idPersonajeReceptor;
    }
    public void setIdPersonajeReceptor(int idPersonajeReceptor){
        this.idPersonajeReceptor=idPersonajeReceptor;
    }
    public String getNombrePersonajeReceptor(){
        return nombrePersonajeReceptor;
    }
    public void setNombrePersonajeReceptor(String nombrePersonajeReceptor){
        this.nombrePersonajeEmisor=nombrePersonajeEmisor;
    }
    public int getIdMovimiento(){
        return idMovimiento;
    }
    public void setIdMovimiento(int idMovimiento){
        this.idMovimiento=idMovimiento;
    }
    public String getNombreMovimiento(){
        return nombreMovimiento;
    }
    public void setNombreMovimiento(String nombreMovimiento){
        this.nombreMovimiento=nombreMovimiento;
    }
    public String getNombreEscenario(){
        return nombreEscenario;
    }
    public void setNombreEscenario(String nombreEscenario){
        this.nombreEscenario=nombreEscenario;
    }
    public int getIdPosicionEscenario(){
        return idPosicionEscenario;
    }
    public void setIdPosicionEscenario(int idPosicionEscenario){
        this.idPosicionEscenario=idPosicionEscenario;
    }
    public String getNombrePosicionEscenario(){
        return nombrePosicionEscenario;
    }
    public void setNombrePosicionEscenario(String nombrePosicionEscenario){
        this.nombrePosicionEscenario=nombrePosicionEscenario;
    }

    public int getPorcentajeKO(){
        return porcentajeKO;
    }
    public void setPorcentajeKO(int porcentajeKO){
        this.porcentajeKO=porcentajeKO;
    }

}
