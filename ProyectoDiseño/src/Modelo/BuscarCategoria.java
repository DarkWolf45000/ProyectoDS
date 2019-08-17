/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.commons.lang.StringUtils;
/**
 *
 * @author DiegoY
 */
public class BuscarCategoria implements Buscar{
    private String Categoria;

    @Override
    public Producto Buscarproducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
