package dao;

import conexaoBanco.SqliteConnection;
import dto.LogDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LogDao {

    public LogDTO read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        LogDTO logDto = new LogDTO();

        try {
            stmt = con.prepareStatement("SELECT * FROM tipoPersistenciaLog");
            rs = stmt.executeQuery();
            
            logDto.setLogType(rs.getInt("numTipo"));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return logDto;
    }
    
    public void updateType(int logType){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("UPDATE tipoPersistenciaLog SET numTipo = ?");
            stmt.setInt(1, logType);

            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }   
    
}
