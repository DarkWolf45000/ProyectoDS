/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bodega;
import Modelo.Producto;
import Modelo.User;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LuisEduardo
 */
public class ControlStock {
    
    
    public ArrayList<Producto> obtenerProductos(String parametro,String criterio){
        ArrayList<Producto> lib;
        if(criterio.equalsIgnoreCase("Por nombre")){
            lib=Producto.buscarNombre(parametro);
        }else if(criterio.equalsIgnoreCase("Por descripcion")){
            lib=Producto.buscarDescripcion(parametro);
        }else if(criterio.equalsIgnoreCase("Por categoria")){
            lib=Producto.buscarCategoria(parametro);
        }else{
            lib=Producto.productosTodos();
        }
        return lib;
    }
     public Producto consultarProducto(String nombre){
        ArrayList<Producto> p=new ArrayList<>();
       
        try{
            p=Producto.buscarNombre(nombre);
            if(p==null){
                return null;
            }
            Producto prod= p.get(0);
            return prod;
        }catch(Exception e){
            //alerta de que se escribieron letras en vez de numeros
        }
        return null;
    }       

    public boolean actualizarPrecio(String id, String nombre, String categoria, String precio) {
        if(id.isEmpty() && nombre.isEmpty() && categoria.isEmpty() && precio.isEmpty()){
            return false;
        }
        int idPrec;
        float prec;
        try{
             idPrec= Integer.parseInt(id);
             prec= Float.parseFloat(precio);
        } catch (Exception e){
            return false;
            //crear alerta de que datos ingresados estan en formato invalido
        }
        Producto.actualizarprecio(idPrec,nombre,categoria,prec);
        return true;
    }
    
}
