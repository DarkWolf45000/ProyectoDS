/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LuisEduardo
 */
public class JefeBodega extends Persona{
    private Bodega bodega;

    public JefeBodega(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    
    
}
