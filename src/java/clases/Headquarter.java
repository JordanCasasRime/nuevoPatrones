/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Prototype.IClone;

/**
 *
 * @author Giordano
 */
public class Headquarter implements IClone {
    private String nombre;
    private String direccion;
    private int aforo;
    private int sedeid;
    
    public Headquarter(String nombre, String direccion, int aforo ,int sedeId){
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforo = aforo;
        this.sedeid = sedeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getSedeId() {
        return sedeid;
    }

    public void setSedeId(int sedeId) {
        this.sedeid = sedeId;
    }
    
    @Override
    public IClone clone() {
        IClone headquarters = new Headquarter(this.nombre, this.direccion, this.aforo, this.sedeid);
        return headquarters;
    }
    
}
