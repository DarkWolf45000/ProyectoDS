/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategy;

import Controlador.ControlLogIn;
import Estrategy.Buscar;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DiegoY
 */
public class BuscarCategoria implements Buscar{
    private String Categoria;

    @Override
    public ResultSet Buscarproducto(String parametro) {
        try{
            String sql= "{call buscar_categoria(?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setString(1, parametro);
            ResultSet rs = cst.executeQuery();
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    

    
}
