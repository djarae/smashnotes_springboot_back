package com.example.smashnotest_back;
public class Registro
{
    private int id;
    private int idPersonajeEmisor;
    private int idPersonajeReceptor;
    private int idMovimiento;
    private int idPosicionEscenario;
    private int porcentajeKO;

    public Registro(
            int id,
            int idPersonajeEmisor,
            int idPersonajeReceptor,
            int idMovimiento,
            int idPosicionEscenario,
            int porcentajeKO){
                super();
                this.id=id;
                this.idPersonajeEmisor=idPersonajeEmisor;
                this.idPersonajeReceptor=idPersonajeReceptor;
                this.idMovimiento=idMovimiento;
                this.idPosicionEscenario=idPosicionEscenario;
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
    public int getIdPersonajeReceptor(){
        return idPersonajeReceptor;
    }
    public void setIdPersonajeReceptor(int idPersonajeReceptor){
        this.idPersonajeReceptor=idPersonajeReceptor;
    }
    public int getIdMovimiento(){
        return idMovimiento;
    }
    public void setIdMovimiento(int idMovimiento){
        this.idMovimiento=idMovimiento;
    }
    public int getIdPosicionEscenario(){
        return idPosicionEscenario;
    }
    public void setIdPosicionEscenario(int idPosicionEscenario){
        this.idPosicionEscenario=idPosicionEscenario;
    }
    public int getPorcentajeKO(){
        return porcentajeKO;
    }
    public void setPorcentajeKO(int porcentajeKO){
        this.porcentajeKO=porcentajeKO;
    }

}
