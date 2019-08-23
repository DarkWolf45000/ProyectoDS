
package strategy;

import controlador.ControlLogIn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 *
 * @author LuisEduardo
 */
public class BuscarNombre implements Buscar{

    @Override
    public ResultSet Buscarproducto(String parametro) {
        try{
            String sql= "{call buscar_nombre(?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setString(1, parametro);
            return cst.executeQuery();
        }catch (Exception e){
            Logger.getLogger(BuscarNombre.class.getName()).warning("Error en conexión");
        }
        return null;
    }

   
    
}
