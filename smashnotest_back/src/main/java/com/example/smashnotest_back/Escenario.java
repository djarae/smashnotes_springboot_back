package com.example.smashnotest_back;
public class Escenario {
    private int id;
    private String nombre;
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
