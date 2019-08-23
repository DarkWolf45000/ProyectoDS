package modelo;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.logging.Logger;

/**
 *
 * @author LuisEduardo
 */
public abstract class Pedido {
    protected int id;
    protected Date horaS;
    protected Date horaE;
    protected String estadoEntrega;
    protected Repartidor rep;
    protected DataBase db;

    public Pedido(int id, String estadoEntrega, DataBase db) {
        this.id = id;
        this.estadoEntrega = estadoEntrega;
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getDireccion();

    public Date getHoraS() {
        return horaS;
    }

    public void setHoraS(Date horaS) {
        this.horaS = horaS;
    }

    public Date getHoraE() {
        return horaE;
    }

    public void setHoraE(Date horaE) {
        this.horaE = horaE;
    }

    
    

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public Repartidor getRep() {
        return rep;
    }

    public void setRep(Repartidor rep) {
        this.rep = rep;
    }
    
    public void actualizarEstadoPedido(String idRepartidor, String estado){
        try{
            String sql= "{call ped_actualizarEstado(?,?,?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, this.id);
            cst.setString(2, idRepartidor);
            cst.setString(3, estado);
            cst.executeQuery();
        }catch (Exception e){
            Logger.getLogger(Pedido.class.getName()).warning("Error en conexión estado pedido");
        }
    }
    
    public static Pedido obtenerPedido(int idPedido,DataBase db){
        try{
            String sql= "{call ped_especifico(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idPedido);
            ResultSet rs = cst.executeQuery();
            if(rs.next()){
                Pedido ped=new PedidoLocal(idPedido,rs.getString(2),db);
                ped.setHoraE(rs.getDate(4));
                ped.setHoraS(rs.getDate(3));
                ped.setRep(Repartidor.obtenerRepartidor(rs.getString(1),db));
                return ped;
            }
            return null;
        }catch (Exception e){
            Logger.getLogger(Pedido.class.getName()).warning("Error en conexión obtener pedido");
            return null;
        }
    }
    //falta arreglar lo de la fecha
    public static void actualizarPedido(int idPedido,String idRepartidor,String estado,String horasal,String horaent,DataBase db){
        try{
            String sql= "{call ped_actualizar(?,?,?,?,?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idPedido);
            cst.setString(2, idRepartidor);
            cst.setString(3, estado);
            cst.setTime(4, Time.valueOf(horasal));
            cst.setTime(5, Time.valueOf(horaent));
            cst.executeQuery();
        }catch (Exception e){
            Logger.getLogger(Pedido.class.getName()).warning("Error en conexión actualizar pedido");
        }
    }
    
    public static int obtenerSiguienteId(DataBase db){
        try{
            String sql= "{call MaxIDPedido()}";
            CallableStatement cst=db.getC().prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            if(rs.next()){
                return rs.getInt(1)+1;
            }
        }catch (Exception e){
            Logger.getLogger(Pedido.class.getName()).warning("Error en conexión obtener id");
        }
        return 0;
    }
    
}
