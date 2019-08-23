/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategy;

import Controlador.ControlLogIn;
import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author LuisEduardo
 */
public class BuscarDescripcion implements Buscar{

    @Override
    public ResultSet Buscarproducto(String parametro) {
        try{
            String sql= "{call buscar_descripcion(?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setString(1, parametro);
            return cst.executeQuery();
    
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

   
    
}
