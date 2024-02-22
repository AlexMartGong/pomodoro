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

    public void insertDB(String taskname, int cantidadP) throws SQLException {
        try {
            String sql = "INSERT INTO tasks (idtask, taskname, cantidad) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, taskname);
            ps.setInt(3, cantidadP);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OperationsDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
    }

    public void deleteTasks(int taskId) throws SQLException {

        try {
            
            String sql = "DELETE FROM tasks WHERE idtask=" + taskId;
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            con.close();
        }

    }

}
