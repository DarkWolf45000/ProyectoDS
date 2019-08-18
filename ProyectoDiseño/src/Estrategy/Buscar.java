/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategy;

import Modelo.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DiegoY
 */
public interface Buscar {
     public ResultSet Buscarproducto(String parametro);
}
