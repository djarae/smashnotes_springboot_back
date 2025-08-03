package smashnotest_back.dtos;
public class RegistroDTO
{
    private int id;
    private int idPersonajeEmisor;
    private String nombrePersonajeEmisor;
    private int idPersonajeReceptor;
    private String nombrePersonajeReceptor;
    private int idMovimiento;
    private String nombreMovimiento;
    private int idEscenario;
    private String nombreEscenario;
    private int idPosicion;
    private String nombrePosicion;
    private int rage;
    private boolean di;
    private int porcentajeKO;

    //Esta clase deberia tener mas data por el uso de JOIN para el listado de registros
    public RegistroDTO(
            int id,
            int idPersonajeEmisor,
            String nombrePersonajeEmisor,
            int idPersonajeReceptor,
            String nombrePersonajeReceptor,
            int idMovimiento,
            String nombreMovimiento,
            int idEscenario,
            String nombreEscenario,
            int idPosicion,
            String nombrePosicion,
            int rage,
            boolean di,
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
        this.idEscenario=idEscenario;
        this.nombreEscenario=nombreEscenario;
        this.idPosicion=idPosicion;
        this.nombrePosicion=nombrePosicion;
        this.rage=rage;
        this.di=di;
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
    public int getIdEscenario(){
        return idEscenario;
    }
    public void setIdEscenario(int idEscenario){
        this.idEscenario=idEscenario;
    }
    public String getNombreEscenario(){
        return nombreEscenario;
    }
    public void setNombreEscenario(String nombreEscenario){
        this.nombreEscenario=nombreEscenario;
    }
    public int getIdPosicion(){
        return idPosicion;
    }
    public void setIdPosicion(int idPosicion){
        this.idPosicion=idPosicion;
    }
    public String getNombrePosicion(){
        return nombrePosicion;
    }
    public void setNombrePosicion(String nombrePosicion){
        this.nombrePosicion=nombrePosicion;
    }
    public int getRage(){
        return rage;
    }
    public void setRage(int rage){
        this.rage=rage;
    }
    public boolean getDi(){
        return di;
    }
    public void setDi(boolean di){
        this.di=di;
    }
    public int getPorcentajeKO(){
        return porcentajeKO;
    }
    public void setPorcentajeKO(int porcentajeKO){
        this.porcentajeKO=porcentajeKO;
    }

}
