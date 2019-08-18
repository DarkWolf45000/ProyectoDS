/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Controlador.ControlLogIn.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LuisEduardo
 */
public class Repartidor extends Persona{
    private boolean disponible;

    public Repartidor(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        disponible=true;
    }

    public static ArrayList<Repartidor> cargarDatos(DataBase db,int idBodega){
        ArrayList<Repartidor> listr=new ArrayList<>();
        try{
            String sql= "{call repartidor_bodega(?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setInt(1, idBodega);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                Repartidor rep=new Repartidor(rs.getString(1),rs.getString(2),rs.getString(3));
                listr.add(rep);
            }
            
        }catch (Exception e){
            System.out.println(e);
            return listr;
        }
        return listr;
    }
    

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
