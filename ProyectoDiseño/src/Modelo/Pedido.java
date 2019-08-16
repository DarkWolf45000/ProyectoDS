/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author LuisEduardo
 */
class Pedido {
    private Repartidor repartidor;
    private LocalDate horaS;
    private LocalDate horaE;
    private String estadoEntrega;
    private DataBase db;

    public Pedido(Repartidor repartidor, LocalDate horaS, LocalDate horaE, String estadoEntrega, DataBase db) {
        this.repartidor = repartidor;
        this.horaS = horaS;
        this.horaE = horaE;
        this.estadoEntrega = estadoEntrega;
        this.db = db;
    }
    
    
    
    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
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
