/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiseño;

import Modelo.BD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LuisEduardo
 */
public class LogIn extends Application {
    Connection cn=BD.getConexion();
    @Override
    public void start(Stage primaryStage) {
        Label lbtit=new Label("Log In");

        Label lbus=new Label("Usuario: ");
        TextField txtus=new TextField();


        Label lbcont=new Label("Contrasena: ");
        PasswordField txtcont=new PasswordField();

        Button btn = new Button("Entrar");


        StackPane sp=new StackPane();
        StackPane sp2=new StackPane();
        VBox vb=new VBox(10);
        GridPane gp=new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        sp.getChildren().add(lbtit);
        sp2.getChildren().add(btn);

        gp.add(lbus, 0, 0);
        gp.add(txtus,1,0);

        gp.add(lbcont, 0, 1);
        gp.add(txtcont,1,1);

        vb.getChildren().addAll(sp,gp,sp2);

        Scene scene = new Scene(vb, 300, 250);

        primaryStage.setTitle("Log In");
        primaryStage.setScene(scene);
        
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String us=txtus.getText();
                String cont=txtcont.getText();
                if(us.equalsIgnoreCase("") || cont.equalsIgnoreCase("")){
                    //mensaje faltan datos
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Falta usuario o contraseña");
                    alert.showAndWait();
                }else{
                    if(verificar(us,cont)){
                        //procedimiento que lleve a la ventana de empleados o admin segun sea el caso
                    }
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public boolean verificar (String usuario, String contraseña){
        try{
            String sql= "{call verificar(?,?)";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                String user=rs.getString(1);
                String pass=rs.getString(2);
                if(usuario.equals(user)&& contraseña.equals(pass)){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
   /* public static Empleado verificarCuenta(String us, String contra){
        for(Empleado e: Empleado.listEmpleado){
                if(e.getUsuario().getUsuario().equals(us) && e.getUsuario().comprobarClave(contra)){
                    return e;
                }
        }
        return null;
    }

    public static void SeleccionarEscena(Empleado emp, Stage st, Scene scp){
        if(emp instanceof Administrador){
            st.setTitle("Administrador Menu");
            st.setScene(AdministradorMenu.vetanaAdmin(st, scp,(Administrador)emp));
        }else if(emp instanceof Planificador){
            st.setTitle("Planificador Menu");
        }else if(emp instanceof Cajero){
            st.setTitle("Cajero Menu");
        }
    }*/
    
}
