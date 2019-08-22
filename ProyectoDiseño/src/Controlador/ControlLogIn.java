/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BD;
import Modelo.DataBase;
import Modelo.User;
import Modelo.Usuario;
import Vistas.AdminV;
import Vistas.ManejarStock;
import Vistas.Pedidos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LuisEduardo
 */
public class ControlLogIn {

    public static DataBase db = new BD();
    public static Connection cn = db.getConexion();

    public boolean verificar(String usuario, String contraseña) {
        try {
            String sql = "{call verificar(?,?)}";
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                if (usuario.equals(user) && contraseña.equals(pass)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
            return false;
        }
    }

    private ResultSet getUsuario(String sql, String usuario, String contraseña) {
        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            return rs;

        } catch (SQLException e) {
            Logger.getLogger(e.toString());
            return null;
        }

    }

    public User obtenerAdministrador(String usuario, String contraseña) throws SQLException {
        String sql = "{call obtenerAdmins(?,?)}";
        ResultSet rs = getUsuario(sql, usuario, contraseña);
        while (rs.next()) {
            Usuario u = new Usuario(usuario, contraseña, "Administrador", null, rs.getString(1), rs.getString(2), rs.getString(3));
            return u;
        }
        return null;
    }

    public User obtenerGerente(String usuario, String contraseña) throws SQLException {
        String sql = "{call obtenerGerente(?,?)}";
        ResultSet rs = getUsuario(sql, usuario, contraseña);
        while (rs.next()) {
            Usuario u = new Usuario(usuario, contraseña, "Gerente", null, rs.getString(1), rs.getString(2), rs.getString(3));
            return u;
        }
        return null;
    }

    public User obtenerVendedor(String usuario, String contraseña) throws SQLException {
        String sql = "{call obtenerVendedor(?,?)}";
        ResultSet rs = getUsuario(sql, usuario, contraseña);
        while (rs.next()) {
            Usuario u = new Usuario(usuario, contraseña, "Administrador", null, rs.getString(1), rs.getString(2), rs.getString(3));
            return u;
        }
        return null;
    }

    public User obtenerJefeBodega(String usuario, String contraseña) throws SQLException {
        String sql = "{call obtenerJefeBodega(?,?)}";
        ResultSet rs = getUsuario(sql, usuario, contraseña);
        while (rs.next()) {
            Usuario u = new Usuario(usuario, contraseña, "Administrador", null, rs.getString(1), rs.getString(2), rs.getString(3));
            return u;
        }
        return null;
    }

    public void siguientePantalla(String usuario, String cont, Stage st, Scene scp) throws SQLException {
        User u = obtenerAdministrador(usuario, cont);
        if (u != null) {
            //cabiar al menu de admin
            Logger.getLogger("Admin");
            st.setScene(AdminV.menuAdmin(u, st, scp));
        }
        u = obtenerGerente(usuario, cont);
        if (u != null) {
            Logger.getLogger("Gerente");
            st.setScene(ManejarStock.menuGerente(u, st, scp));
        }
        u = obtenerVendedor(usuario, cont);
        if (u != null) {
            Logger.getLogger("Vendedor");
        }
        u = obtenerJefeBodega(usuario, cont);
        if (u != null) {
            st.setScene(Pedidos.menuJefeBodega(u, st, scp));
            Logger.getLogger("Jefebodega");
        }
    }
}
