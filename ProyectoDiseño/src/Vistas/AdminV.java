/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.User;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gianc
 */
public class AdminV {
    private static void InfoImplementacion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info Dialog");
        alert.setHeaderText("INFO");
        alert.setContentText("Esta función será implementada en futuras versiones");
        alert.showAndWait();
    }
    
    public static Scene menuAdmin(User u,Stage st,Scene scp){
        VBox vb=new VBox(20);
        Label lbtit=new Label("MENU JEFE BODEGA");
        Button btncl=new Button("Modificar Clientes");
        Button btnven=new Button("Modificar vendedores");
        Button btnger=new Button("Modificar gerentes");
        Button btnrep=new Button("Modificar repartidores");
        Button btnjef=new Button("Modificar jefe de bodegas");
        Button btnmen=new Button("Salir");
        vb.getChildren().addAll(lbtit,btncl,btnven,btnger,btnrep,btnjef,btnmen);
        Scene sc=new Scene(vb,350,350);
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
            st.setScene(scp);
        });
        
        btncl.setOnMouseClicked((MouseEvent e)->{
            InfoImplementacion();
        });
        
        btnven.setOnMouseClicked((MouseEvent e)->{
            InfoImplementacion();
        });
        
        btnger.setOnMouseClicked((MouseEvent e)->{
            InfoImplementacion();
        });
        
        btnrep.setOnMouseClicked((MouseEvent e)->{
            InfoImplementacion();
        });
        
        btnjef.setOnMouseClicked((MouseEvent e)->{
            InfoImplementacion();
        });
        
        return sc;
    }
}
