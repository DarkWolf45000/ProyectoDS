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
public class Venta extends Tramite{
    private Pagar pagar;

    public Venta(Cliente cliente,DataBase db) {
        super(cliente, db);
        
    }

    

    public Pagar getPagar() {
        return pagar;
    }

    public void setPagar(Pagar pagar) {
        this.pagar = pagar;
    }
    
    public void cargarDatosVenta(int idPedido){
        this.listProducto=Producto.cargarDatosPedido(db, idPedido);
    }
    
    
}
