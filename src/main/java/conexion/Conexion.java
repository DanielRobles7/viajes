/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Teresa Acostha
 */
public class Conexion {

    static String bd = "vuelos";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost/" + bd + "?useSSL=false";
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("La conexion ha sido establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion " + e);
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {

        Conexion conn = new Conexion();
    }
}
