/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LuisEduardo
 */
public class Vehiculo {
    private String idVehiculo;
    private String color;
    private String modelo;
    private String placa;
    private String tipo;
    private DataBase db;

    public Vehiculo(String idVehiculo, String color, String modelo, String placa, String tipo, DataBase db) {
        this.idVehiculo = idVehiculo;
        this.color = color;
        this.modelo = modelo;
        this.placa = placa;
        this.tipo = tipo;
        this.db = db;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    
}
