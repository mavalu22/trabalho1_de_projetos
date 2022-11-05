/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoBanco.SqliteConnection;
import dto.BonusDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BonusDao {

    public void create(BonusDTO bonus, String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome); 
            
            
            stmt = con.prepareStatement("INSERT INTO Bonus (idFuncionario, nome, data, valor) VALUES (?, ?, CURRENT_DATE(), ?)");            
            stmt.setInt(1, id);
            stmt.setString(2, bonus.getNome());
            stmt.setDouble(3, bonus.getValor());
            
            stmt.executeUpdate();


        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public void createByList(ArrayList<BonusDTO> bonusList, String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome); 
            
            for(BonusDTO bonus : bonusList){
                stmt = con.prepareStatement("INSERT INTO Bonus (idFuncionario, nome, data, valor) VALUES (?, ?, CURRENT_DATE(), ?)");            
                stmt.setInt(1, id);
                stmt.setString(2, bonus.getNome());
                stmt.setDouble(3, bonus.getValor());
                stmt.executeUpdate();                
            }                       

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }

    public List<BonusDTO> read(String nome) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<BonusDTO> listBonusDTO = new ArrayList<>();

        try {
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome);
            
            stmt = con.prepareStatement("SELECT * FROM Bonus WHERE idFuncionario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while(rs.next()){
                BonusDTO bonus = new BonusDTO();
                bonus.setIdBonus(rs.getInt("idBonus"));
                bonus.setIdFuncionario(rs.getInt("idFuncionario"));
                bonus.setNome(rs.getString("nome"));
                bonus.setData(rs.getString("data"));
                bonus.setValor(rs.getDouble("valor"));
                
                listBonusDTO.add(bonus);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listBonusDTO;
    }
    
    public List<BonusDTO> readByNome(String nomeBonus) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<BonusDTO> listBonusDTO = new ArrayList<>();

        try {
            
            stmt = con.prepareStatement("SELECT * FROM Bonus WHERE nome = ?");
            stmt.setString(1, nomeBonus);
            rs = stmt.executeQuery();

            while(rs.next()){
                BonusDTO bonus = new BonusDTO();
                bonus.setIdBonus(rs.getInt("idBonus"));
                bonus.setIdFuncionario(rs.getInt("idFuncionario"));
                bonus.setNome(rs.getString("nome"));
                bonus.setData(rs.getString("data"));
                bonus.setValor(rs.getDouble("valor"));
                
                listBonusDTO.add(bonus);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listBonusDTO;
    } 
    
    public List<BonusDTO> readByValor(double valorBonus) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<BonusDTO> listBonusDTO = new ArrayList<>();

        try {
            
            stmt = con.prepareStatement("SELECT * FROM Bonus WHERE valor = ?");
            stmt.setDouble(1, valorBonus);
            rs = stmt.executeQuery();

            while(rs.next()){
                BonusDTO bonus = new BonusDTO();
                bonus.setIdBonus(rs.getInt("idBonus"));
                bonus.setIdFuncionario(rs.getInt("idFuncionario"));
                bonus.setNome(rs.getString("nome"));
                bonus.setData(rs.getString("data"));
                bonus.setValor(rs.getDouble("valor"));
                
                listBonusDTO.add(bonus);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listBonusDTO;
    } 
    
    public void update(BonusDTO bonus , String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome);
            
            stmt = con.prepareStatement("UPDATE Bonus SET nome = ?, valor = ? WHERE idFuncionario = ?");
            stmt.setString(1, bonus.getNome());
            stmt.setDouble(2, bonus.getValor());
            stmt.setInt(3, id);

            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }

    public void updateByList(ArrayList<BonusDTO> bonusList, String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome); 
            
            for(BonusDTO bonus : bonusList){

                stmt = con.prepareStatement("UPDATE Bonus SET nome = ?, valor = ? WHERE idFuncionario = ?");
                stmt.setString(1, bonus.getNome());
                stmt.setDouble(2, bonus.getValor());
                stmt.setInt(3, id);

                stmt.executeUpdate();             
            }                       

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public void delete(BonusDTO bonus , String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome); 
            
            stmt = con.prepareStatement("DELETE FROM Bonus WHERE idFuncionario = ?, nome = ?, valor = ?");
            stmt.setInt(1, id);
            stmt.setString(2, bonus.getNome());
            stmt.setDouble(3, bonus.getValor());
            stmt.executeUpdate();


        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }

    public void deleteByList(ArrayList<BonusDTO> bonusList, String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            FuncionarioDao consultaFuncionarioID = new FuncionarioDao();
            int id = consultaFuncionarioID.getIdByName(nome); 
            
            for(BonusDTO bonus : bonusList){
                stmt = con.prepareStatement("DELETE FROM Bonus WHERE idFuncionario = ?, nome = ?, valor = ?");
                stmt.setInt(1, id);
                stmt.setString(2, bonus.getNome());
                stmt.setDouble(3, bonus.getValor());
                stmt.executeUpdate();           
            }                       


        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
}
