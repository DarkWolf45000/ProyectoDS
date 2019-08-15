/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author LuisEduardo
 */
public class Local {
    private String idlocal;
    private String direccion;
    private ArrayList<Producto> listProducto;
    private ArrayList<Usuario> listVendedores;
    private Gerente gerente;
    private Usuario administrador;
    private boolean isMatriz;
    private DataBase db;
    private static Local matriz;

    public Local(String idlocal, String direccion, ArrayList<Producto> listProducto, ArrayList<Usuario> listVendedores, Gerente gerente, Usuario administrador, DataBase db) {
        this.idlocal = idlocal;
        this.direccion = direccion;
        this.listProducto = listProducto;
        this.listVendedores = listVendedores;
        this.gerente = gerente;
        this.administrador = administrador;
        this.db = db;
        
    }

    private Local(String idlocal, String direccion, ArrayList<Producto> listProducto, ArrayList<Usuario> listVendedores, Gerente gerente, Usuario administrador, boolean isMatriz, DataBase db) {
        this.idlocal = idlocal;
        this.direccion = direccion;
        this.listProducto = listProducto;
        this.listVendedores = listVendedores;
        this.gerente = gerente;
        this.administrador = administrador;
        this.isMatriz = isMatriz;
        this.db = db;
    }
    
    public static Local GetMatriz(){
        
        
        return Local.matriz;
    }
    
}
