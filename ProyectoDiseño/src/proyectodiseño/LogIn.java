
package proyectodiseño;

import controlador.ControlLogIn;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LuisEduardo
 */
public class LogIn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ControlLogIn cgl=new ControlLogIn();
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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                if(us.equalsIgnoreCase("") || cont.equalsIgnoreCase("")){
                    //mensaje faltan datos
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Falta usuario o contraseña");
                    alert.showAndWait();
                }else{
                    if(cgl.verificar(us,cont)){
                        try {
                            //procedimiento que lleve a la ventana de empleados o admin segun sea el caso
                            cgl.siguientePantalla(us,cont,primaryStage,scene);
                        } catch (SQLException ex) {
                            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                    
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Usuario o contraseña inválida");
                    alert.showAndWait();
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
    
    
}
