
package Estrategy;

import Controlador.ControlLogIn;
import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiegoY
 */
public class BuscarCategoria implements Buscar{

    @Override
    public ResultSet Buscarproducto(String parametro) {
        try{
            String sql= "{call buscar_categoria(?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setString(1, parametro);
            return cst.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    

    
}
