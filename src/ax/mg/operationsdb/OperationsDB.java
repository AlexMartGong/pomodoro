package ax.mg.operationsdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ax.mg.connect.ConnectMySql;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationsDB {

    ConnectMySql conn = new ConnectMySql();
    Connection con = conn.connectMySQL();

    public void insertDB(String nameTask, int numberP) throws SQLException {
        try {
            String sql = "INSERT INTO completedtasks (idcompletedtask, nametasks, cantidad) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, nameTask);
            ps.setInt(3, numberP);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OperationsDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
    }

}
