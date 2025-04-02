package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {
    private String USER = "ufzweie06jhgqxhv";
    private String PASSWORD = "nT0wvf00n8Z1VxtoVMx0";
    private String URL = "jdbc:mysql://ufzweie06jhgqxhv:nT0wvf00n8Z1VxtoVMx0@brodel4o8np8eguscotp-mysql.services.clever-cloud.com:3306/brodel4o8np8eguscotp";

    Connection connectar() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public List<Ninja> getNinjas(){
        String sql = "select * from ninja";
        List<Ninja> ninjaList = new ArrayList<>();
        try(Connection connection = connectar();
            PreparedStatement r = connection.prepareStatement(sql)) {

            ResultSet result = r.executeQuery();

            while (result.next()){
                Ninja ninja = new Ninja(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
                );
                ninjaList.add(ninja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninjaList;
    }
    public Ninja getNinjaPorID(int idNinja){
        String sql = "select * from ninja where id = ?";
        Ninja ninja = new Ninja();
        try(Connection connection = connectar();
            PreparedStatement r = connection.prepareStatement(sql)) {

            r.setInt(1,idNinja);
            ResultSet result = r.executeQuery();

            while (result.next()){
                ninja = new Ninja(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninja;
    }
}
