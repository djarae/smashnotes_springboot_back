package smashnotest_back.model;

public class Escenario {
    private int id;
    private String nombre;

    public Escenario(){
        super();
        this.id=0;
        this.nombre="";
    }


    public Escenario(int id, String nombre){
        super();
        this.id=id;
        this.nombre=nombre;
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


}
