package smashnotest_back;

public class Personaje {
    private int id;
    private int echo;
    private String nombre;

    public Personaje(int id,int echo, String nombre){
        super();
        this.id=id;
        this.echo=echo;
        this.nombre=nombre;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getEcho(){
        return echo;
    }
    public void setEcho(int id){
        this.echo=echo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}
