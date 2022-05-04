/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudClientesDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kam
 */
public class conexion {
    String srtConnection = "jdbc:sqlite:C:/Users/kam/Desktop/db/sistema.s3db";
    Connection conn = null;
    
    public conexion (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(srtConnection);
            System.out.println("Connection Done");
        } catch (Exception e) {
            System.out.println("Error Conection: " + e);
        }
    }
    
    public int sqlSentence(String strSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet checkClients(String strSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSQL);
            ResultSet resp = pstm.executeQuery();
            return resp;
            
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
