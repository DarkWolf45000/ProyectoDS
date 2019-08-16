/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.JefeBodega;
import Modelo.Pedido;
import Modelo.Ruta;
import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author LuisEduardo
 */
public class ControlJefeBodega {
    
    public void crearRuta(TextArea ta, ArrayList<Pedido> ped,JefeBodega jf){
        
        Ruta rt=new Ruta(jf.getBodega().repartidorDisponible(),ped,ta.getText());
        rt.imprimirRuta();
    }
    
    
    
    
}
