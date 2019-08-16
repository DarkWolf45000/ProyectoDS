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
public class Pedido {
    private LocalDate horaS;
    private LocalDate horaE;
    private String estadoEntrega;
    private String direccion;
    private DataBase db;
    public static ArrayList<Pedido> listPedido=new ArrayList<>();

    public Pedido(String estadoEntrega, DataBase db,String direccion){
        this.direccion=direccion;
        this.estadoEntrega = estadoEntrega;
        this.db = db;
    }

    public String getDireccion() {
        return direccion;
    }
    
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
    
    
    
}
