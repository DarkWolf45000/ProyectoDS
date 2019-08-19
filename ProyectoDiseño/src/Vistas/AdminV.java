/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControlStock;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.User;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    
    public static Scene actualizarPrecio(User u,Stage st, Scene scp){
        ControlStock cs=new ControlStock();
        VBox vb=new VBox();
        Label lbtitr=new Label("ACTUALIZAR PRECIO");
        
        Label lbtit=new Label("Buscar Producto");
        
        TextField txtidb=new TextField();
        Button btnbus=new Button("Buscar");
        
        HBox hb=new HBox(20);
        hb.getChildren().addAll(lbtit,txtidb,btnbus);
        
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        txtid.setEditable(false);
        
        Label lbnom=new Label("Nombre:");
        TextField txtnom=new TextField();
        txtnom.setEditable(false);
        
        Label lbcat=new Label("Categoria: ");
        TextField txtcat=new TextField();
        txtcat.setEditable(false);
        
        Label lbprec=new Label("Precio: ");
        TextField txtprec=new TextField();
        
        
        
        GridPane gp=new GridPane();
        
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
       
        
        gp.add(lbnom, 0, 3);
        gp.add(txtnom, 1, 3);
        
        gp.add(lbcat, 0, 4);
        gp.add(txtcat, 1, 4);
        
        gp.add(lbprec, 0, 5);
        gp.add(txtprec, 1, 5);
        
        Button btng=new Button("Guardar");
        Button btnmen=new Button("Menu");
        HBox hbb=new HBox(20);
        hbb.getChildren().addAll(btng,btnmen);
        vb.getChildren().addAll(lbtitr,hb,gp,hbb);
        Scene sc=new Scene(vb,400,400);
        
        btnbus.setOnMouseClicked((MouseEvent e)->{
            String id=txtidb.getText();
            if(!id.equalsIgnoreCase("")){
                Producto p=cs.consultarProducto(id);
                if(p==null){
                    //alerta de que no se encontro
                    System.out.println("no se encontro la wea :,v");
                    txtid.clear();
                    txtnom.clear();
                    txtcat.clear();
                    txtprec.clear();
                }else{
                    txtid.setText(String.valueOf(p.getIdProducto()));
                    txtnom.setText(p.getNombre());
                    txtcat.setText(p.getModelo());
                    txtprec.setText(String.valueOf(p.getPrecio()));
                }
            }else{
                //alerta de que no se puso el id
                System.out.println(".,v");
            }
        });
        
        btng.setOnMouseClicked((MouseEvent e)->{
            
           if(cs.actualizarPrecio(txtid.getText(), txtnom.getText(), txtcat.getText(), txtprec.getText())){
               txtid.clear();
               txtnom.clear();
               txtcat.clear();
               txtprec.clear();
           }else{
               //alerta de error
           }
        
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
           st.setScene(menuAdmin(u,st,scp));
        
        });
        
        return sc;
    }
    public static Scene actualizarStock(User u,Stage st, Scene scp){
        ControlStock cs=new ControlStock();
        VBox vb=new VBox();
        Label lbtitr=new Label("ACTUALIZAR Stock");
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        
        Label lbnom=new Label("Local:");
        TextField txtidbod=new TextField();
        
        Label lbcat=new Label("Cantidad: ");
        TextField txtcat=new TextField();
        
        GridPane gp=new GridPane();
        
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
        gp.add(lbnom, 0, 3);
        gp.add(txtidbod, 1, 3);
        
        gp.add(lbcat, 0, 5);
        gp.add(txtcat, 1, 5);
        
        Button btng=new Button("Actualizar");
        Button btnmen=new Button("Menu");
        HBox hbb=new HBox(20);
        hbb.getChildren().addAll(btng,btnmen);
        vb.getChildren().addAll(lbtitr,gp,hbb);
        Scene sc=new Scene(vb,300,300);
        
        btng.setOnMouseClicked((MouseEvent e)->{
            
           if(cs.actualizarStock(txtid.getText(), txtidbod.getText(), txtcat.getText())){
               txtid.clear();
               txtidbod.clear();
               txtcat.clear();
               
           }else{
               //alerta de error
           }
        
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
           st.setScene(menuAdmin(u,st,scp));
        
        });
        
        return sc;
    }
    public static Scene ingresarStock(User u,Stage st, Scene scp){
        ControlStock cs=new ControlStock();
        VBox vb=new VBox();
        Label lbtitr=new Label("INGRESAR Stock");
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        
        Label lbnom=new Label("Local:");
        TextField txtidbod=new TextField();
        
        Label lbcat=new Label("Cantidad: ");
        TextField txtcat=new TextField();
        
        GridPane gp=new GridPane();
        
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
        gp.add(lbnom, 0, 3);
        gp.add(txtidbod, 1, 3);
        
        gp.add(lbcat, 0, 5);
        gp.add(txtcat, 1, 5);
        
        Button btng=new Button("Ingresar");
        Button btnmen=new Button("Menu");
        HBox hbb=new HBox(20);
        hbb.getChildren().addAll(btng,btnmen);
        vb.getChildren().addAll(lbtitr,gp,hbb);
        Scene sc=new Scene(vb,300,300);
        
        btng.setOnMouseClicked((MouseEvent e)->{
            
           if(cs.ingresarStock(txtid.getText(), txtidbod.getText(), txtcat.getText())){
               txtid.clear();
               txtidbod.clear();
               txtcat.clear();
               
           }else{
               //alerta de error
           }
        
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
           st.setScene(menuAdmin(u,st,scp));
        
        });
        
        return sc;
    }
    public static Scene menuAdmin(User u,Stage st,Scene scp){
        VBox vb=new VBox(20);
        Label lbtit=new Label("MENU ADMIN");
        Button btncl=new Button("Modificar Clientes");
        Button btnven=new Button("Modificar vendedores");
        Button btnger=new Button("Modificar gerentes");
        Button btnrep=new Button("Modificar repartidores");
        Button btnjef=new Button("Modificar jefe de bodegas");
        Button btnist=new Button("Ingresar stock");
        Button btnast=new Button("Actualizar stock");
        Button btnapr=new Button("Actualizar precio de venta");
        Button btnmen=new Button("Salir");
        vb.getChildren().addAll(lbtit,btncl,btnven,btnger,btnrep,btnjef,btnist,btnast,btnapr,btnmen);
        Scene sc=new Scene(vb,350,450);
        
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
        
        btnist.setOnMouseClicked((MouseEvent e)->{
            st.setScene(ingresarStock(u,st,scp));
        });
        
        btnast.setOnMouseClicked((MouseEvent e)->{
            st.setScene(actualizarStock(u, st, scp));
        });
        
        btnapr.setOnMouseClicked((MouseEvent e)->{
            st.setScene(actualizarPrecio(u,st,scp));
        });
        return sc;
    }
}
