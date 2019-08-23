/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.ControlJefeBodega;
import controlador.ControlLogIn;
import modelo.JefeBodega;
import modelo.Pedido;
import modelo.User;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
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
    
    private Pedidos(){}
    
    public static Scene menuJefeBodega(User u,Stage st,Scene scp){
        ControlJefeBodega cjb=new ControlJefeBodega();
        JefeBodega jb=cjb.cargarDatos(u);
        VBox vb=new VBox(20);
        Label lbtit=new Label("MENU JEFE BODEGA");
        StackPane sp=new StackPane();
        sp.getChildren().add(lbtit);
        Button btnvr=new Button("Crear Rutas");
        StackPane sp2=new StackPane();
        sp2.getChildren().add(btnvr);
        Button btnap=new Button("Actualizar Pedido");
        StackPane sp3=new StackPane();
        sp3.getChildren().add(btnap);
        Button btnmen=new Button("Salir");
        StackPane sp4=new StackPane();
        sp4.getChildren().add(btnmen);
        vb.getChildren().addAll(sp,sp2,sp3,sp4);
        Scene sc=new Scene(vb,300,300);
        
        btnmen.setOnMouseClicked((MouseEvent e)->
            st.setScene(scp)
        );
        
        btnap.setOnMouseClicked((MouseEvent e)->
            st.setScene(Pedidos.actualizarPedidos(jb,cjb, st, sc))
        );
        
        btnvr.setOnMouseClicked((MouseEvent e)->
            st.setScene(Pedidos.visualizarRutas(jb,cjb, st, sc))
        );
        
        return sc;
    }
    
    
    public static Scene visualizarRutas(JefeBodega jb,ControlJefeBodega cjb,Stage st, Scene scp){
        jb.getBodega().cargarPedidos();
        VBox vb=new VBox(20);
        
        Label lbtit=new Label("Creacion de Rutas");
        StackPane sp=new StackPane();
        sp.getChildren().add(lbtit);
        TableView tvPedido=new TableView();
        
        TableColumn<String, Pedido> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setPrefWidth(100);
        TableColumn<String, Pedido> column2 = new TableColumn<>("Estado");
        column2.setCellValueFactory(new PropertyValueFactory<>("estadoEntrega"));
        column2.setPrefWidth(200);
        TableColumn<String, Pedido> column3 = new TableColumn<>("Direccion");
        column3.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        column3.setPrefWidth(200);
        

        tvPedido.getColumns().addAll(column1,column2,column3);
        List<Pedido> listpd=jb.getBodega().pedidosAEntregar();
        tvPedido.setItems(FXCollections.observableList(listpd));
        
        TextArea ta=new TextArea();
        ta.setEditable(false);
        
        Button btncr=new Button("Crear");
        Button btnmen=new Button("Menu");
        HBox hb=new HBox(40);
        hb.getChildren().addAll(btncr,btnmen);
        hb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(sp,tvPedido,ta,hb);
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
            }
        });
        
        btnmen.setOnMouseClicked((MouseEvent e)->
            st.setScene(scp)
        );
        
        return sc;
    }
    
    public static void textoRuta(TextArea ta,Pedido ped,List<Pedido> ar){
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
        VBox vb=new VBox(20);
        Label lbtitr=new Label("ACTUALIZAR PEDIDOS");
        StackPane sp=new StackPane();
        sp.getChildren().add(lbtitr);
        Label lbtit=new Label("Buscar Pedido");
        
        TextField txtidb=new TextField();
        Button btnbus=new Button("Buscar");
        
        HBox hb=new HBox(20);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(lbtit,txtidb,btnbus);
        
        Label lbid=new Label("Id: ");
        TextField txtid=new TextField();
        txtid.setEditable(false);
        
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
        gp.setAlignment(Pos.CENTER);
        gp.add(lbid, 0, 0);
        gp.add(txtid, 1, 0);
        
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
        hbb.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        vb.getChildren().addAll(sp,hb,gp,hbb);
        Scene sc=new Scene(vb,500,500);
        
        btnbus.setOnMouseClicked((MouseEvent e)->{
            String id=txtidb.getText();
            if(!id.equalsIgnoreCase("")){
                Pedido p=cjb.consultarPedido(id,ControlLogIn.db);
                if(p==null){
                    //alerta de que no se encontro
                    txtid.clear();
                    txtes.clear();
                    txtrep.clear();
                }else{
                    txtid.setText(String.valueOf(p.getId()));
                    txtes.setText(p.getEstadoEntrega());
                    txtrep.setText(p.getRep().getCedula());
                }
            }else{
                //alerta de que no se puso el id
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
        
        btnmen.setOnMouseClicked((MouseEvent e)->
           st.setScene(scp)
        
        );
        
        return sc;
    }
    
}
