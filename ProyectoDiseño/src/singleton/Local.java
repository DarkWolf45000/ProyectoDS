/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import modelo.DataBase;
import modelo.Gerente;
import modelo.Producto;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisEduardo
 */
public class Local {
    private int idlocal; //
    private String direccion;//
    private List<Producto> listProducto=new ArrayList<>();
    private List<Usuario> listVendedores = new ArrayList<>();
    private Gerente gerente;
    private Usuario administrador;
    private boolean isMatriz; //
    private DataBase db;//
    private static Local matriz;//

    public Local(int id,DataBase db) {
        this.idlocal=id;
        this.db = db;
        this.isMatriz=false;
    }

    private Local(int id,boolean isMatriz, DataBase db) {
        this.idlocal=id;
        this.isMatriz = isMatriz;
        this.db = db;
    }
    
    public static Local createMatriz(DataBase db,int id,String dir){
        if(Local.matriz==null){
            Local rm=new Local(id,true,db);
            rm.setDireccion(dir);
            matriz=rm;
            return rm;
        }else{
            return Local.matriz;
        }
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    public String getDireccion() {
        return direccion;
    }
       
    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(ArrayList<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public List<Usuario> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(ArrayList<Usuario> listVendedores) {
        this.listVendedores = listVendedores;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public boolean isIsMatriz() {
        return isMatriz;
    }

    public void setIsMatriz(boolean isMatriz) {
        this.isMatriz = isMatriz;
    }
    
    
    
}
