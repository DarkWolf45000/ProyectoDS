/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LuisEduardo
 */
public abstract class Pedido {
    protected int id;
    protected LocalDate horaS;
    protected LocalDate horaE;
    protected String estadoEntrega;
    protected DataBase db;

    public Pedido(int id, String estadoEntrega, DataBase db) {
        this.id = id;
        this.estadoEntrega = estadoEntrega;
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getDireccion();

    
    public LocalDate getHoraS() {
        return horaS;
    }

    public void setHoraS(LocalDate horaS) {
        this.horaS = horaS;
    }

    public LocalDate getHoraE() {
        return horaE;
    }

    public void setHoraE(LocalDate horaE) {
        this.horaE = horaE;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    public void actualizarEstadoPedido(){
        
    }
    
}
