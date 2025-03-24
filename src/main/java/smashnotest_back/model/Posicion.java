package smashnotest_back.model;

public class Posicion {
    private int id;
    private String nombre;
    private int verticalHorizontal;
    private int idPosicionComun;
    private int idEscenario;

    public Posicion(int id, String nombre, int verticalHorizontal, int idPosicionComun, int idEscenario){
        super();
        this.id=id;
        this.nombre=nombre;
        this.verticalHorizontal=verticalHorizontal;
        this.idPosicionComun=idPosicionComun;
        this.idEscenario=idEscenario;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getVerticalHorizontal(){
        return verticalHorizontal;
    }
    public void setVerticalHorizontal(int verticalHorizontal){
        this.verticalHorizontal=verticalHorizontal;
    }
    public int getIdPosicionComun(){
        return idPosicionComun;
    }
    public void setIdPosicionComun(int idPosicionComun){
        this.idPosicionComun=idPosicionComun;
    }
    public int getIdEscenario(){
        return idEscenario;
    }
    public void setIdEscenario(int idEscenario){
        this.idEscenario=idEscenario;
    }

}
