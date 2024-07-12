package ar.com.codo24100.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
    
    //obtener una conexion
    public static Connection conectar() {
        //logica para obtener la conexion
        String url = "jdbc:mysql://127.0.0.1:3306/tragosdb?serverTimeZone=UTC&userSSL=false";
        String user = "root";
        String password = "root";
        //como usamos jdbc necesitamos decirle que driver vamos a usar: Mysql
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;

        //como puede dar un error entonces try/catch
        try{
            //si va todo bien
            //forName es un metodo estatico: que no necesito una instancia para usar dicho metodo            
            Class.forName(driver);

            //me conecto
            connection = DriverManager.getConnection(url, user, password);
        }catch(Exception e) {
            //si falla
            System.err.println("No se ha podido conectar al la db:" + e.getMessage());
        }

        return connection;
    }
    
    public static void desconectar(Connection connection) {
        //controlo el posible error del metodo close
        try{
            connection.close();
        }catch(Exception e) {
            System.err.println(e);
        }
    }

}
