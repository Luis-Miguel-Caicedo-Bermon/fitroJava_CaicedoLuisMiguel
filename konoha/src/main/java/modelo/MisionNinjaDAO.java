package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MisionNinjaDAO {
    private String USER = "ufzweie06jhgqxhv";
    private String PASSWORD = "nT0wvf00n8Z1VxtoVMx0";
    private String URL = "jdbc:mysql://ufzweie06jhgqxhv:nT0wvf00n8Z1VxtoVMx0@brodel4o8np8eguscotp-mysql.services.clever-cloud.com:3306/brodel4o8np8eguscotp";

    Connection connectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public void asignarMision(MisionNinja mn){
        String sql = "insert into misionNinja(idNinja,idMision,fechaInicio,fechaFin) values(?,?,?,?)";
        try(Connection connection = connectar();
            PreparedStatement r = connection.prepareStatement(sql)) {

            r.setInt(1,mn.getIdNinja());
            r.setInt(2,mn.getIdMision());
            r.setString(3,mn.getFechaInicio());
            r.setString(4,mn.getFechafin());
            r.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void completarMision(int idMision, String fechaFin){
        String sql = "update misionNinja set fechaFin = ? where idMision = ?;";
        try(Connection connection = connectar();
            PreparedStatement r = connection.prepareStatement(sql)) {

            r.setString(1,fechaFin);
            r.setInt(2,idMision);
            r.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
