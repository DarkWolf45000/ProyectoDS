
package strategy;

import controlador.ControlLogIn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

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
            Logger.getLogger(BuscarCategoria.class.getName()).warning("Error en conexión");
        }
        return null;
    }

    

    
}
