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
import Modelo.User;
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
import javafx.stage.Stage;

/**
 *
 * @author LuisEduardo
 */
public class Pedidos {
    
    public static Scene menuJefeBodega(User u,Stage st,Scene scp){
        ControlJefeBodega cjb=new ControlJefeBodega();
        JefeBodega jb=cjb.cargarDatos(u);
        VBox vb=new VBox(20);
        Label lbtit=new Label("MENU JEFE BODEGA");
        Button btnvr=new Button("Crear Rutas");
        Button btnap=new Button("Actualizar Rutas");
        Button btnmen=new Button("Salir");
        vb.getChildren().addAll(lbtit,btnvr,btnap,btnmen);
        Scene sc=new Scene(vb,300,300);
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
            st.setScene(scp);
        });
        
        btnap.setOnMouseClicked((MouseEvent e)->{
            st.setScene(Pedidos.actualizarPedidos(jb,cjb, st, sc));
        });
        
        btnvr.setOnMouseClicked((MouseEvent e)->{
            st.setScene(Pedidos.visualizarRutas(jb,cjb, st, sc));
        });
        
        return sc;
    }
    
    
    public static Scene visualizarRutas(JefeBodega jb,ControlJefeBodega cjb,Stage st, Scene scp){
        
        VBox vb=new VBox(20);
        
        Label lbtit=new Label("Creacion de Rutas");
        
        TableView tvPedido=new TableView();
        
        TableColumn<String, Pedido> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<String, Pedido> column2 = new TableColumn<>("Estado");
        column2.setCellValueFactory(new PropertyValueFactory<>("estadoEntrega"));

        TableColumn<String, Pedido> column3 = new TableColumn<>("Direccion");
        column3.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        

        tvPedido.getColumns().addAll(column1,column2,column3);
        //Conseguir lista con el controller
       // tvPedido.setItems(FXCollections.observableList(jb.getBodega().pedidosAEntregar()));
        ArrayList<Pedido> listpd=jb.getBodega().pedidosAEntregar();
        tvPedido.setItems(FXCollections.observableList(listpd));
        
        TextArea ta=new TextArea();
        ta.setEditable(false);
        
        Button btncr=new Button("Crear");
        Button btnmen=new Button("Menu");
        HBox hb=new HBox();
        hb.getChildren().addAll(btncr,btnmen);
        vb.getChildren().addAll(lbtit,tvPedido,ta,hb);
        Scene sc=new Scene(vb,500,500);
        ArrayList<Pedido> ar=new ArrayList<>();
        tvPedido.setOnMouseClicked((MouseEvent e)->{
            if(tvPedido.getSelectionModel().getSelectedItem()!=null){
            textoRuta(ta,(Pedido) tvPedido.getSelectionModel().getSelectedItem(),ar);
            }
        });
        
        btncr.setOnMouseClicked((MouseEvent e)->{
            if(cjb.crearRuta(ta, ar,jb)){
                ta.clear();
                listpd.removeAll(ar);
                ar.clear();
                tvPedido.refresh();
            }else{
                
            }
            
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
            st.setScene(scp);
        });
        
        return sc;
    }
    
    public static void textoRuta(TextArea ta,Pedido ped,ArrayList<Pedido> ar){
        if(ta.getText().contains(ped.getDireccion())){
            if(ar.get(0).equals(ped)){
                ta.setText(ta.getText().replaceAll(ped.getDireccion(), ""));
                ta.setText(ta.getText().replaceAll("-", ""));
            }else{
                ta.setText(ta.getText().replaceAll("-"+ped.getDireccion(), ""));
            }
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
    
    public static Scene actualizarPedidos(JefeBodega jb,ControlJefeBodega cjb,Stage st, Scene scp){
        VBox vb=new VBox();
        Label lbtitr=new Label("ACTUALIZAR PEDIDOS");
        
        Label lbtit=new Label("Buscar Pedido");
        
        TextField txtidb=new TextField();
        Button btnbus=new Button("Buscar");
        
        HBox hb=new HBox(20);
        hb.getChildren().addAll(lbtit,txtidb,btnbus);
        
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        txtid.setEditable(false);
     /*   Label lbdir=new Label("Direccion: ");
        TextField txtdir=new TextField();
        txtdir.setEditable(false);*/
        
        Label lbes=new Label("Estado de entrega:");
        TextField txtes=new TextField();
        
        Label lbhs=new Label("Hora de Salida(ss:mm:hh): ");
        TextField txths=new TextField();
        
        Label lbhe=new Label("Hora de Entrega(ss:mm:hh): ");
        TextField txthe=new TextField();
        
        Label lbrep=new Label("Cedula Repartidor: ");
        TextField txtrep=new TextField();
        txtrep.setEditable(false);
        GridPane gp=new GridPane();
        
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
       /* gp.add(lbdir, 0, 1);
        gp.add(txtdir, 1, 1);*/
        
        gp.add(lbrep, 0, 2);
        gp.add(txtrep, 1, 2);
        
        gp.add(lbes, 0, 3);
        gp.add(txtes, 1, 3);
        
        gp.add(lbhs, 0, 4);
        gp.add(txths, 1, 4);
        
        gp.add(lbhe, 0, 5);
        gp.add(txthe, 1, 5);
        
        
        Button btng=new Button("Guardar");
        Button btnmen=new Button("Menu");
        HBox hbb=new HBox(20);
        hbb.getChildren().addAll(btng,btnmen);
        vb.getChildren().addAll(lbtitr,hb,gp,hbb);
        Scene sc=new Scene(vb,500,500);
        
        btnbus.setOnMouseClicked((MouseEvent e)->{
            String id=txtidb.getText();
            if(!id.equalsIgnoreCase("")){
                Pedido p=cjb.consultarPedido(id);
                if(p==null){
                    //alerta de que no se encontro
                    System.out.println("no se encontro la wea :,v");
                    txtid.clear();
                  //  txtdir.setText(p.getDireccion());
                    txtes.clear();
                    txtrep.clear();
                }else{
                    txtid.setText(String.valueOf(p.getId()));
                  //  txtdir.setText(p.getDireccion());
                    txtes.setText(p.getEstadoEntrega());
                    txtrep.setText(p.getRep().getCedula());
                }
            }else{
                //alerta de que no se puso el id
                System.out.println(".,v");
            }
        });
        
        btng.setOnMouseClicked((MouseEvent e)->{
            
           if(cjb.actualizarPedido(txtid.getText(), txtrep.getText(), txths.getText(), txthe.getText(), txtes.getText(),jb)){
               txtid.clear();
               txtes.clear();
               txtrep.clear();
               txths.clear();
               txthe.clear();
           }else{
               //alerta de error
           }
        
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->{
           st.setScene(scp);
        
        });
        
        return sc;
    }
    
}
