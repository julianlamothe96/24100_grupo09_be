package ar.com.codo24100.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24100.web.domain.Tragos;
import ar.com.codo24100.web.dto.TragosDTO;

public class MySQLCrudImpl implements ICrud {
    
    // Implementar el/los método/s de ICrud
    public Tragos getById(Long idTrago) {       
        String sql = "SELECT * FROM tragos WHERE idTrago = " + idTrago;

        Tragos trago = null;

        Connection con = null;
        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            // Leer el result y crear mis entidades 

            // Si hay datos, solo existe un registro
            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String nombre = resultSet.getString(2);

                trago = new Tragos(id, nombre);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }

        return trago;
    }
    
    public void create(TragosDTO dto) {
        String sql = "INSERT INTO tragos (nombreTrago) VALUES (?)";
        
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            // Seteo en orden cada parámetro
            pst.setString(1, dto.getNombreTrago());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    // Implementamos el delete
    @Override
    public void delete(Long pk) {
        Connection cnx = null;
        String sql = "DELETE FROM tragos WHERE idTrago = ?";
        try {
            // Conectarme a la DB
            cnx = AdministradorDeConexiones.conectar();
            PreparedStatement pstmt = cnx.prepareStatement(sql);
            pstmt.setLong(1, pk);
            if (pstmt.executeUpdate() > 0)
                System.out.println("El trago con ID=" + pk + " ha sido eliminado.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.desconectar(cnx);
        } 
    }

    public ArrayList<Tragos> findAll() {       
        String sql = "SELECT * FROM tragos";

        ArrayList<Tragos> tragos = new ArrayList<>();

        Connection con = null;
        try {
            con = AdministradorDeConexiones.conectar();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            // Leer el result y crear mis entidades 

            // Si hay datos, solo existe un registro
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String nombre = resultSet.getString(2);

                Tragos trago = new Tragos(id, nombre);
                tragos.add(trago);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorDeConexiones.desconectar(con);
        }

        return tragos;
    }

    public void update(TragosDTO trago) {
        String sql = "UPDATE tragos SET nombreTrago = ? WHERE idTrago = ?";
        
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            // Seteo en orden cada parámetro
            pst.setString(1, trago.getNombreTrago());
            pst.setLong(2, trago.getIdTrago());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }
}