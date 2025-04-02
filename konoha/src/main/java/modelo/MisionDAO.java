package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MisionDAO {
    private String USER = "ufzweie06jhgqxhv";
    private String PASSWORD = "nT0wvf00n8Z1VxtoVMx0";
    private String URL = "jdbc:mysql://ufzweie06jhgqxhv:nT0wvf00n8Z1VxtoVMx0@brodel4o8np8eguscotp-mysql.services.clever-cloud.com:3306/brodel4o8np8eguscotp";

    Connection connectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public List<Mision> getMisionesDisponibles(){
        String sql = "SELECT * FROM mision where id not in(select idMision from misionNinja)";
        List<Mision> misionList = new ArrayList<>();
        try(Connection connection = connectar();
            PreparedStatement r = connection.prepareStatement(sql)) {

            ResultSet result = r.executeQuery();

            while (result.next()){
                Mision mision = new Mision(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getDouble(4)
                );
                misionList.add(mision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misionList;
    }
}
