package dao;

import conexaoBanco.SqliteConnection;
import dto.BonusDTO;
import dto.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    public void create(FuncionarioDTO funcionario){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO Funcionario (nome, idade, salario, salarioBase, cargo, falta, tempoServico, qtdMembroFamilia, distanciaTrabalho, valorTotalBonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setDouble(4, funcionario.getSalarioBase());
            stmt.setString(5, funcionario.getCargo());
            stmt.setInt(6, funcionario.getFalta());
            stmt.setInt(7, funcionario.getTempoServico());
            stmt.setInt(8, funcionario.getQtdMembroFamilia());
            stmt.setDouble(9, funcionario.getDistanciaTrabalho());
            stmt.setDouble(10, funcionario.getValorTotalBonus());
            
            stmt.executeUpdate();

            
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public List<FuncionarioDTO> read() {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario");
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);

            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }    

    
    public void update(FuncionarioDTO funcionario){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            int id = getIdByName(funcionario.getNome());
            
            stmt = con.prepareStatement("UPDATE Funcionario SET nome = ?, idade = ?, cargo = ?, falta = ?, salario = ?, falta = ?, salario = ?, salarioBase = ?, tempoServico = ?, qtdMembroFamilia = ?, distanciaTrabalho = ?, valorTotalBonus = ? WHERE id = ?");
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setDouble(4, funcionario.getSalarioBase());
            stmt.setString(5, funcionario.getCargo());
            stmt.setInt(6, funcionario.getFalta());
            stmt.setInt(7, funcionario.getTempoServico());
            stmt.setInt(8, funcionario.getQtdMembroFamilia());
            stmt.setDouble(9, funcionario.getDistanciaTrabalho());
            stmt.setDouble(10, funcionario.getValorTotalBonus());
            stmt.setInt(11, id);

            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }

    public void delete(String nome){
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM pessoaFisica WHERE nome = ?");
            stmt.setString(1, nome);
            stmt.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt);
        }
    }
    
    public List<FuncionarioDTO> readByNome(String nome) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.nome = ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }  
    
    public List<FuncionarioDTO> readByIdade(int idade) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.idade = ?");
            stmt.setInt(1, idade);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    } 
    
    
    public List<FuncionarioDTO> readBySalario(double salario) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.salario = ?");
            stmt.setDouble(1, salario);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readBysalarioBase(double salarioBase) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.salarioBase = ?");
            stmt.setDouble(1, salarioBase);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readByCargo(String cargo) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.cargo = ?");
            stmt.setString(1, cargo);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readByFalta(int falta) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.falta = ?");
            stmt.setInt(1, falta);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readTempoServico(int tempoServico) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.tempoServico = ?");
            stmt.setInt(1, tempoServico);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readTempoQtdMembroFamilia(int qtdMembroFamilia) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.qtdMembroFamilia = ?");
            stmt.setInt(1, qtdMembroFamilia);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readTempoDistanciaTrabalho(double distanciaTrabalho) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.distanciaFamilia = ?");
            stmt.setDouble(1, distanciaTrabalho);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public List<FuncionarioDTO> readTempoValorTotalBonus(double valorTotalBonus) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FuncionarioDTO> listFuncionarioDTO = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.valorTotalBonus = ?");
            stmt.setDouble(1, valorTotalBonus);
            rs = stmt.executeQuery();

            while(rs.next()){
                FuncionarioDTO funcionario = new FuncionarioDTO();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setSalarioBase(rs.getDouble("salarioBase"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setFalta(rs.getInt("falta"));
                funcionario.setTempoServico(rs.getInt("tempoServico"));
                funcionario.setQtdMembroFamilia(rs.getInt("qtdMembroFamilia"));
                funcionario.setDistanciaTrabalho(rs.getDouble("distanciaTrabalho"));
                funcionario.setValorTotalBonus(rs.getDouble("valorTotalBonus"));
                
                listFuncionarioDTO.add(funcionario);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return listFuncionarioDTO;
    }
    
    public int getIdByName(String nomeFuncionario) {
        Connection con = SqliteConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario where Funcionario.nome = ?");
            stmt.setString(1, nomeFuncionario);
            rs = stmt.executeQuery();

            id = rs.getInt("id");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            SqliteConnection.closeConnection(con, stmt, rs);
        }
        return id;
    }    
    
}
