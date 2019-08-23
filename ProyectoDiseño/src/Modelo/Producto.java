package Modelo;

import Controlador.ControlLogIn;
import Estrategy.Buscar;
import Estrategy.BuscarCategoria;
import Estrategy.BuscarDescripcion;
import Estrategy.BuscarNombre;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


/**
 *
 * @author LuisEduardo
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantDisp;
    private String modelo;
    protected DataBase db;
    private static Buscar bq;
    private TextField cantdeseada;
    private CheckBox isdeseado;
            
            
    public Producto(int idProducto, String descripcion, float precio, int cantDisp, String modelo) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantDisp = cantDisp;
        this.modelo = modelo;
        cantdeseada = new TextField();
        isdeseado=new CheckBox();
        
    }

    public TextField getCantdeseada() {
        return cantdeseada;
    }

    public void setCantdeseada(TextField cantdeseada) {
        this.cantdeseada = cantdeseada;
    }

    public CheckBox getIsdeseado() {
        return isdeseado;
    }

    public void setIsdeseado(CheckBox isdeseado) {
        this.isdeseado = isdeseado;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(int cantDisp) {
        this.cantDisp = cantDisp;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public Buscar getBq() {
        return bq;
    }

   
    
    public static ArrayList<Producto> cargarDatosBodega(DataBase db,int idBodega){
        ArrayList<Producto> listp=new ArrayList<>();
        try{
            String sql= "{call ObtenerProductosBodega(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idBodega);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                Producto p=new Producto(rs.getInt(2),rs.getString(3),rs.getFloat(5),rs.getInt(1),rs.getString(4));
                listp.add(p);
            }
            
        }catch (Exception e){
            System.out.println(e);
            return listp;
        }
        return listp;
    } 
    
    public static HashMap<Producto,Integer> cargarDatosPedido(DataBase db, int idPedido){
        HashMap<Producto,Integer> hm=new HashMap<>();
        try{
            String sql= "{call obtenerProductosPedido(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idPedido);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                Producto p=new Producto(rs.getInt(1),rs.getString(2),rs.getFloat(4),0,rs.getString(3));
                hm.put(p,rs.getInt(5));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return hm;
    }
    
    public static ArrayList<Producto> buscarNombre(String nom){
        ArrayList<Producto> lp=new ArrayList<>();
        Producto.bq=new BuscarNombre();
        ResultSet rs=bq.Buscarproducto(nom);
        try {
            while(rs.next()){
                Producto p=new Producto(rs.getInt(1),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(3));
                p.setNombre(rs.getString(2));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    public static ArrayList<Producto> buscarDescripcion(String desc){
        ArrayList<Producto> lp=new ArrayList<>();
        Producto.bq=new BuscarDescripcion();
        ResultSet rs=bq.Buscarproducto(desc);
        try {
            while(rs.next()){
                Producto p=new Producto(rs.getInt(1),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(3));
                p.setNombre(rs.getString(2));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    public static ArrayList<Producto> buscarCategoria(String cat){
        ArrayList<Producto> lp=new ArrayList<>();
        Producto.bq=new BuscarCategoria();
        ResultSet rs=bq.Buscarproducto(cat);
        try {
            while(rs.next()){
                Producto p=new Producto(rs.getInt(1),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(3));
                p.setNombre(rs.getString(2));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    public static ArrayList<Producto> productosTodos(){
        ArrayList<Producto> lp=new ArrayList<>();
        try {
            String sql= "{call obtenerProductosTodos}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                Producto p=new Producto(rs.getInt(1),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(3));
                p.setNombre(rs.getString(2));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    public static void actualizarprecio(int idPrec, String nombre, String categoria, float prec) {
        try{
            String sql= "{call prec_actualizar(?,?,?,?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setInt(1, idPrec);
            cst.setString(2, nombre);
            cst.setString(3, categoria);
            cst.setFloat(4, prec);
            cst.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void actualizarStock(int idProd, int idLocal, int cant) {
        try{
            String sql= "{call stock_actualizar(?,?,?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setInt(1, idProd);
            cst.setInt(2,idLocal);
            cst.setInt(3, cant);
            cst.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void ingresarStock(int idProd, int idLocal, int cant) {
        try{
            String sql= "{call stock_ingresar(?,?,?)}";
            CallableStatement cst=ControlLogIn.db.getC().prepareCall(sql);
            cst.setInt(1, idProd);
            cst.setInt(2,idLocal);
            cst.setInt(3, cant);
            cst.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
