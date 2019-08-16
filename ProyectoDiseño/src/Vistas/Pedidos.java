/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControlJefeBodega;
import Modelo.JefeBodega;
import Modelo.Ruta;
import Modelo.Pedido;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author LuisEduardo
 */
public class Pedidos {
    
    public static Scene visualizarRutas(JefeBodega jb){
        VBox vb=new VBox(20);
        ControlJefeBodega cjb=new ControlJefeBodega();
        
        Label lbtit=new Label("Creacion de Rutas");
        
        TableView tvPedido=new TableView();
        ArrayList<Pedido> lr=new ArrayList<>();
        
        TableColumn<String, Pedido> column1 = new TableColumn<>("Estado");
        column1.setCellValueFactory(new PropertyValueFactory<>("estadoEntrega"));

        TableColumn<String, Pedido> column2 = new TableColumn<>("Direccion");
        column2.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<String, Pedido> column3 = new TableColumn<>("Descripcion");
        column3.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        

        tvPedido.getColumns().addAll(column1,column2,column3);
        //Conseguir lista con el controller
        tvPedido.setItems(FXCollections.observableList(Pedido.listPedido));
        
        TextArea ta=new TextArea();
        ta.setEditable(false);
        
        Button btncr=new Button("Crear");
        
        Scene sc=new Scene(vb,500,500);
        ArrayList<Pedido> ar=new ArrayList<Pedido>();
        tvPedido.setOnMouseClicked((MouseEvent e)->{
            textoRuta(ta,(Pedido) tvPedido.getSelectionModel().getSelectedItem());
            
        });
        
        btncr.setOnMouseClicked((MouseEvent e)->{
            cjb.crearRuta(ta, lr,jb);
        });
        
        
        return sc;
    }
    
    public static void textoRuta(TextArea ta,Pedido ped){
        if(ta.getText().contains(ped.getDireccion())){
            ta.setText(ta.getText().replaceAll(ped.getDireccion(), ""));
            ta.setText(ta.getText().replaceAll("--", "-"));
        }else{
            if(ta.getText().equals("")){
                ta.setText(ped.getDireccion());
            }else{
                ta.setText(ta.getText()+"-"+ped.getDireccion());
            }
        }
    }
    
    public static Scene actualizarPedidos(){
        return null;
    }
    
}
