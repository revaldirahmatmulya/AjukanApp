/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Revaldi
 */
public class konfig {
    
    private static Connection MySQLConfig;
    
    public static Connection configDB()throws SQLException{
        try{
            String url ="jdbc:mysql://localhost:3306/db_aplikasi_penjualan";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url,user,pass);
            System.out.println("Sukses !");
        } catch (SQLException e){
            System.out.println("koneksi ke database gagal"+e.getMessage());
        }
        return MySQLConfig;
    }   
    
}

