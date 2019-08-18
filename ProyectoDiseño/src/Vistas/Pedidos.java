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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        vb.getChildren().addAll(lbtit,tvPedido,ta,btncr);
        Scene sc=new Scene(vb,500,500);
        ArrayList<Pedido> ar=new ArrayList<>();
        tvPedido.setOnMouseClicked((MouseEvent e)->{
            textoRuta(ta,(Pedido) tvPedido.getSelectionModel().getSelectedItem(),ar);
            
        });
        
        btncr.setOnMouseClicked((MouseEvent e)->{
            cjb.crearRuta(ta, ar,jb);
        });
        
        
        return sc;
    }
    
    public static void textoRuta(TextArea ta,Pedido ped,ArrayList<Pedido> ar){
        if(ta.getText().contains(ped.getDireccion())){
            ta.setText(ta.getText().replaceAll(ped.getDireccion(), ""));
            ta.setText(ta.getText().replaceAll("--", "-"));
            ar.remove(ped);
        }else{
            ar.add(ped);
            if(ta.getText().equals("")){
                ta.setText(ped.getDireccion());
            }else{
                ta.setText(ta.getText()+"-"+ped.getDireccion());
            }
        }
    }
    
    public static Scene actualizarPedidos(){
        ControlJefeBodega cjb=new ControlJefeBodega();
        VBox vb=new VBox();
        Label lbtit=new Label("Buscar Pedido");
        
        TextField txtidb=new TextField();
        Button btnbus=new Button();
        
        HBox hb=new HBox();
        hb.getChildren().addAll(lbtit,txtidb,btnbus);
        
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        txtid.setEditable(false);
        Label lbdir=new Label("Direccion: ");
        TextField txtdir=new TextField();
        txtdir.setEditable(false);
        
        Label lbes=new Label("Estado de entrega:");
        TextField txtes=new TextField();
        
        Label lbhs=new Label("Hora de Salida: ");
        TextField txths=new TextField();
        
        Label lbhe=new Label("Hora de Entrega: ");
        TextField txthe=new TextField();
        
        Label lbrep=new Label("Cedula Repartidor: ");
        TextField txtrep=new TextField();
        
        GridPane gp=new GridPane();
        
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
        gp.add(lbdir, 0, 1);
        gp.add(txtdir, 1, 1);
        
        gp.add(lbes, 0, 2);
        gp.add(txtes, 1, 2);
        
        gp.add(lbhs, 0, 3);
        gp.add(txths, 1, 3);
        
        gp.add(lbhe, 0, 4);
        gp.add(txthe, 1, 4);
        
        gp.add(lbrep, 0, 5);
        gp.add(txtrep, 1, 5);
        
        Button btng=new Button("Guardar");
        StackPane sp=new StackPane();
        sp.getChildren().add(btng);
        vb.getChildren().addAll(hb,gp,sp);
        Scene sc=new Scene(vb,500,500);
        
        btnbus.setOnMouseClicked((MouseEvent e)->{
            String id=txtidb.getText();
            if(id.equalsIgnoreCase("")){
                Pedido p=cjb.consultarPedido(id);
                if(p==null){
                    //alerta de que no se encontro
                }else{
                    txtid.setText(p.getId());
                    txtdir.setText(p.getDireccion());
                }
            }else{
                //alerta de que no se puso el id
            }
        });
        
        btng.setOnMouseClicked((MouseEvent e)->{
           cjb.actualizarPedido(txtid.getText(), txtrep.getText(), txths.getText(), txthe.getText(), txtes.getText(),null);
        
        });
        
        return sc;
    }
    
}
