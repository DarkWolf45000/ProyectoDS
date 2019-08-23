/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author LuisEduardo
 */
public class AdminDecorator implements User{
    
    private User usuario;
    
    
    public AdminDecorator(User Usuario){
        this.usuario=Usuario;
    }

    @Override
    public String getTipoU() {
        return "Administrador";
    }
    
    
    
    
}
